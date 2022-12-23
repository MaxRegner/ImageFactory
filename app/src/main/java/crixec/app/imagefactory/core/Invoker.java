ackage crixec.app.imagefactory.core;

import android.text.TextUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import crixec.app.imagefactory.util.ShellUtils;

/**
 * Created by crixec on 16-8-10.
 */
public class Invoker {

    private static String TAG = "Invoker";

    private static boolean execInvoker(ShellUtils.Result result, String cmd) {
        String s = getInvoker() + " " + cmd;
        return 0 == ShellUtils.exec(s, result, false);
    }

    public static boolean unpackbootimg(File bootImage, File outputDirectory) {
        return unpackbootimg(bootImage, outputDirectory, null);
    }

    public static boolean unpackbootimg(File bootImage, File outputDirectory, ShellUtils.Result result) {
        String cmd = String.format("unpackbootimg -i \'%s\' -o \'%s\'", bootImage.getPath(), outputDirectory.getPath());
        return execInvoker(result, cmd);
    }

    public static boolean mkbootimg(File config, File kernel, File ramdisk, File second, File dt, File outputFile) {
        return mkbootimg(config, kernel, ramdisk, second, dt, outputFile, null);
    }

    public static boolean mkbootimg(File config, File kernel, File ramdisk, File second, File dt, File outputFile, ShellUtils.Result result) {
        String cmd = String.format("mkbootimg --kernel \'%s\' --ramdisk \'%s\' --second \'%s\' --dt \'%s\' --output \'%s\'", kernel.getPath(), ramdisk.getPath(), second.getPath(), dt.getPath(), outputFile.getPath());
        if (config != null) {
            cmd = String.format("mkbootimg --kernel \'%s\' --ramdisk \'%s\' --second \'%s\' --dt \'%s\' --output \'%s\' --config \'%s\'", kernel.getPath(), ramdisk.getPath(), second.getPath(), dt.getPath(), outputFile.getPath(), config.getPath());
        }
        return execInvoker(result, cmd);
    }

    public static boolean simg2img(File sparseFile, File outputRawFile) {
        return simg2img(sparseFile, outputRawFile, null);
    }

    public static boolean simg2img(File sparseFile, File outputRawFile, ShellUtils.Result result) {
        String cmd = String.format("simg2img \'%s\' \'%s\'", sparseFile.getPath(), outputRawFile.getPath());
        return execInvoker(result, cmd);
    }

    public static boolean img2simg(File rawFile, File sparseFile) {
        return img2simg(rawFile, sparseFile, null);
    }

    public static boolean img2simg(File rawFile, File sparseFile, ShellUtils.Result result) {
        String cmd = String.format("img2simg \'%s\' \'%s\'", rawFile.getPath(), sparseFile.getPath());
        return execInvoker(result, cmd);
    }

    public static boolean compressGzip(File file) {
        return compressGzip(file, null);
    }

    public static boolean compressGzip(File file, ShellUtils.Result result) {
        String cmd = String.format("minigzip -9 \'%s\'", file.getPath());
        return execInvoker(result, cmd);
    }

    public static boolean decompressGzip(File file) {
        return decompressGzip(file, null);
    }

    public static boolean decompressGzip(File file, ShellUtils.Result result) {
        String cmd = String.format("minigzip -d \'%s\'", file.getPath());
        return execInvoker(result, cmd);
    }

    public static boolean splitapp(File app, File outputDir, String filters, ShellUtils.Result result) {
        String cmd = String.format("split_app \'%s\' \'%s\' %s", app.getPath(), outputDir.getPath(), filters);
        return execInvoker(result, cmd);
    }

    public static boolean splitapp(File app, File outputDir, String filters) {
        return splitapp(app, outputDir, filters, null);
    }

    public static boolean splitapp(File app, File outputDir) {
        return splitapp(app, outputDir, null);
    }

    public static boolean splitapp(File app, File outputDir, ShellUtils.Result result) {
        return splitapp(app, outputDir, null, result);
    }

    public static boolean unpackapp(File app, File outputDir, ShellUtils.Result result) {
        String cmd = String.format("unpackapp \'%s\' \'%s\'", app.getPath(), outputDir.getPath());
        return execInvoker(result, cmd);
    }

    public static boolean unpackapp(File app, File outputDir) {
        return unpackapp(app, outputDir, null);
    }

    public static boolean packapp(File outputApp, File inputDir, ShellUtils.Result result) {
        String cmd = String.format("packapp \'%s\' \'%s\'", outputApp.getPath(), inputDir.getPath());
        return execInvoker(result, cmd);
    }

    public static boolean packapp(File outputApp, File inputDir) {
        return packapp(outputApp, inputDir, null);
    }

    public static boolean makeBootImage(File bootImage, File kernel, File ramdisk, File second, File dt) {
        return makeBootImage(bootImage, kernel, ramdisk, second, dt, null);
    }

    public static boolean makeBootImage(File bootImage, File kernel, File ramdisk, File second, File dt, ShellUtils.Result result) {
        String cmd = String.format("makebootimg -k \'%s\' -r \'%s\' -s \'%s\' -d \'%s\' -o \'%s\'", kernel.getPath(), ramdisk.getPath(), second.getPath(), dt.getPath(), bootImage.getPath());
        return execInvoker(result, cmd);
    }

    public static boolean unpackcpio(File cpio, File outputDir) {
        return unpackcpio(cpio, outputDir, null);
    }

    public static boolean unpackcpio(File cpio, File outputDir, ShellUtils.Result result) {
        String cmd = String.format("unpackcpio \'%s\' \'%s\'", cpio.getPath(), outputDir.getPath());
        return execInvoker(result, cmd);
    }

    public static boolean mkcp

            @Override
            public void onStderr(String text) {

            }

            @Override
            public void onCommand(String command) {

            }

            @Override
            public void onFinish(int resultCode) {

            }
        }, cmd);
        return sb;
    }
//
//    public static boolean unpackcpb(File cpb, File outputDir) {
//        return unpackapp(cpb, outputDir, null);
//    }
//
//    public static boolean unpackcpb(File cpb, File outputDir, ShellUtils.Result result) {
//        String cmd = String.format("unpackcpb \'%s\' \'%s\'", cpb.getPath(), outputDir.getPath());
//        return execInvoker(result, cmd);
//    }

    public static String getNativeFakeProgram(String programName) {
        return Constant.LIBRARY_PATH + "/" + programName;
    }

    public static String getInvoker() {
        return getNativeFakeProgram("libinvoker.so");
    }

    public static boolean uncpio(File cpio, File outputDir) {
        return uncpio(cpio, outputDir, null);
    }
    public static boolean uncpio(File cpio, File outputDir, ShellUtils.Result result) {
        outputDir.mkdirs();
        List<String> cmds = new ArrayList<String>();
        cmds.add(String.format("cd \'%s\'", cpio.getParent()));
        cmds.add(String.format("%s uncpio -c \'%s\' -o \'%s\'", getInvoker(), cpio.getPath(), outputDir.getName()));
        return ShellUtils.exec(cmds, result, false) == 0;
    }

    public static boolean mkcpio(File cpioList, File outputFile) {
        return mkcpio(cpioList, outputFile, null);
    }

    public static boolean mkcpio(File cpioList, File outputFile, ShellUtils.Result result) {
        List<String> cmds = new ArrayList<String>();
        cmds.add(String.format("cd \'%s\'", cpioList.getParent()));
        cmds.add(String.format("%s mkcpio \'%s\' \'%s\'", getInvoker(), cpioList.getPath(), outputFile.getPath()));
        return ShellUtils.exec(cmds, result, false) == 0;
    }

    public static boolean sdat2img(File transferList, File datFile, File outputFile) {
        return sdat2img(transferList, datFile, outputFile, null);
    }

    // sdat2img <system.transfer.list> <system.new.dat> <system.ext4.img>
    public static boolean sdat2img(File transferList, File datFile, File outputFile, ShellUtils.Result result) {
        String cmd = String.format("%s sdat2img \'%s\' \'%s\' \'%s\'", getInvoker(), transferList.getPath(), datFile.getPath(), outputFile.getPath());
        return ShellUtils.exec(cmd, result, false) == 0;
    }

}
