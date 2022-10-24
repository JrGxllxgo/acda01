package Exercises;

import java.io.File;
import java.util.Scanner;

public class Ej03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre del directorio: ");
        String directorio = teclado.next();
        File f = new File(directorio);
        if (!f.exists()) {
            System.out.println("La ruta especificada no apunta a ningún fichero ni directorio");
        } else if (f.isDirectory()) {
/*          Con recursividad*/
            borrarDirectorio(f);
//            for (File file : f.listFiles()) {
//                if (file.isDirectory()) {
//                    for (File file2 : file.listFiles()) {
//                        if (file2.isDirectory()) {
//                            for (File file3 : file2.listFiles()) {
//                                file3.delete();
//                            }
//                        }
//                        file2.delete();
//                    }
//                }
//                file.delete();
//            }
//            f.delete();
        } else if (!f.isDirectory()) {
            System.out.println("La ruta establecida no pertenece a un directorio");
        }
    }

    public static void borrarDirectorio(File f) {
        for (File file : f.listFiles()) {
            if (file.isDirectory()){
                borrarDirectorio(file);
            }
            file.delete();
        }
        f.delete();
    }
}
