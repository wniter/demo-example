package com.example.demo.FilesTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @create 2021-12-31 22:10
 */
public class FilesTest {
    public static void main(String[] args) {
        //exists,readAllBytes,createDirectories,copy,write,newInputStream,isDirectory,delete,walkFileTree,
        //createTempDirectory,newOutputStream,deleteIfExists,createTempFile,readAllLines,isRegularFile,newDirectoryStream,
        //move,newBufferedWriter,newBufferedReader,createFile,walk,size,createDirectory,list,lines,notExists,isReadable,
        //readAttributes,getLastModifiedTime,setPosixFilePermissions,isSymbolicLink,isWritable,createSymbolicLink,
        //newByteChannel,probeContentType,isSameFile,getFileAttributeView,readSymbolicLink,setLastModifiedTime,

        //Files.exits()方法用来检查给定的Path在文件系统中是否存在。
        Path path = Paths.get("data/logging.properties");
        boolean pathExists =
                Files.exists(path,
                        new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
        //Files#createDirectory()方法利用Path创建一个新的目录。
        try {
            Path newDir = Files.createDirectory(path);
        } catch(FileAlreadyExistsException e){
            // the directory already exists.
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }
        //Files#copy()方法将文件从一个path复制到另一个。
        Path sourcePath      = Paths.get("data/logging.properties");
        Path destinationPath = Paths.get("data/logging-copy.properties");

        try {
            Files.copy(sourcePath, destinationPath);
        } catch(FileAlreadyExistsException e) {
            //destination file already exists
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }
        //功能太明显了。如果目标文件已存在，会抛出FileAlreadyExistsException，如果试图将文件复制到不存在的目录，会抛出IOException。
        //但也可以要求Files#copy()方法强制覆盖可能存在的文件。
        try {
            Files.copy(sourcePath, destinationPath,
                    StandardCopyOption.REPLACE_EXISTING);// 这个参数
            // 在copy方法的参数列表中加上这个StandardCopyOption.REPLACE_EXISTING，可以在目标文件存在时强制覆盖。
        } catch(FileAlreadyExistsException e) {
            //destination file already exists
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }
        //Files#move()方法将文件从一个path移动到另一个path。同时可以设定目标的文件名，也就是说不仅可以实现移动功能，也可以实现重命名或移动+重命名。
        try {
            Files.move(sourcePath, destinationPath,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            //moving file failed.
            e.printStackTrace();
        }
        //Files#delete()方法可以删除一个文件或文件夹。

        try {
            Files.delete(path);
        } catch (IOException e) {
            //deleting file failed
            e.printStackTrace();
        }
        // public FileVisitResult preVisitDirectory(
        //        Path dir, BasicFileAttributes attrs) throws IOException;
        //
        //    public FileVisitResult visitFile(
        //        Path file, BasicFileAttributes attrs) throws IOException;
        //
        //    public FileVisitResult visitFileFailed(
        //        Path file, IOException exc) throws IOException;
        //
        //    public FileVisitResult postVisitDirectory(
        //        Path dir, IOException exc) throws IOException {
        //Files.walkFileTree()方法可以递归遍历目录树。它使用一个Path和一个FileVisitor作为参数。

        //preVisitDirectory()方法在访问任何目录前被调用。
        //postVisitDirectory()方法在访问任何目录后被调用。
        //visitFile()方法在访问任何文件时被调用。
        //visitFileFailed()在访问任何文件失败时被调用。（比如没权限）
        //每个方法返回；一个FileVisitResult枚举，这些返回指决定了遍历如何进行。包括
        //
        //CONTINUE。表示遍历将继续正常进行。
        //TERMINATE。表示文件遍历将终止。
        //SKIP_SIBLINGS。表示文件遍历将继续，但不在访问此文件/目录的同级文件/目录。
        //SKIP_SUBTREE。表示文件遍历将继续，但不再访问此目录内的文件。
        Path rootPath = Paths.get("data");
        String fileToFind = File.separator + "README.txt";

        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    //System.out.println("pathString = " + fileString);

                    if(fileString.endsWith(fileToFind)){
                        System.out.println("file found at path: " + file.toAbsolutePath());
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }
        //下面是一个通过walkFileTree()方法删除名字为README.txt的文件的示例。注意这里的FileVisitor是继承SimpleFileVisitor的，
        // 不过重写了visitFile方法和postVisitDirectory方法。
        //
        //Files#delete()方法仅在目录为空时删除目录，但下面的代码可以递归删除。
        Path rootpath = Paths.get("data/to-delete");

        try {
            Files.walkFileTree(rootpath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("delete file: " + file.toString());
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    System.out.println("delete dir: " + dir.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public static boolean isDirExists(Path dirPath) {
        //exists  Tests whether a file exists.
        return dirPath != null && Files.exists(dirPath) && Files.isDirectory(dirPath);
    }
    /**
     * 读取文件到byte[].
     *
     * @see {@link Files#readAllBytes}
     */
    public static byte[] toByteArray(final File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }
    public static void createParentDirectories(Path p) throws IOException {
        // merge patch from t3stwhat, fix crash on save to windows path like 'C:\\abc.jar'
        Path parent = p.getParent();
        if (parent != null && !Files.exists(parent)) {
            Files.createDirectories(parent);
        }
    }

}
