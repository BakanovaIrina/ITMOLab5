package InputOutputModule.FileModule;

import java.io.File;

/**
 * Класс, осуществляющий проверку файла и его имени
 */
public class FileValidator implements FileValidatorActions{
    @Override
    public boolean validateFile(File file){
        if (file.exists() && file.canRead() && file.canWrite()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateFileName(String fileName){
        return fileName != null;
    }
}
