package Default;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        AlmacenDispositivos almacen = new AlmacenDispositivos();

        boolean enEjecución = true;

        Scanner lectorConsola = new Scanner(System.in);

        while (enEjecución) {
            mostrarMenu();
            int opcion = leerOpcion(lectorConsola);

            switch (opcion) {
                case 1:
                    altaDispositivo(lectorConsola, almacen);
                    break;
                case 2:
                    registrarSesion(lectorConsola, almacen);
                    break;
                case 3:
                    mostrarInfoDispositivo(lectorConsola, almacen);
                    break;
                case 4:
                    listarDispositivos(almacen);
                    break;
                case 5:
                    mostrarEstadisticas(almacen);
                    break;
                case 0:
                    enEjecución = false;
                    break;
                default:
                    System.out.println("Por favor introduzca una opción entre 0 y 5.");
                    break;

            }

        }

    }

    private static void mostrarMenu() {
        System.out.println("1. Dar de alta un dispositivo.");
        System.out.println("2. Registrar sesión de uso en un dispositivo.");
        System.out.println("3. Mostrar información de un dispositivo.");
        System.out.println("4. Listar dispositivos.");
        System.out.println("5. Mostrar estadísticas globales.");
        System.out.println("0. Salir.");
    }

    private static int leerOpcion(Scanner lectorConsola) {
        try {
            String inputConsola = lectorConsola.nextLine();
            int opcionEscogida = Integer.parseInt(inputConsola);
            return opcionEscogida;
        } catch (Exception e) {
            System.out.println("Por favor introduzca una opción entre 0 y 5.");
        }
        return -1;
    }

    private static double leerDouble(Scanner lectorConsola) {
        try {
            String inputConsola = lectorConsola.nextLine();
            double opcionEscogida = Double.parseDouble(inputConsola);
            return opcionEscogida;
        } catch (Exception e) {
            System.out.println("Por favor introduzca un número");
        }
        return 0.0;
    }

    private static void altaDispositivo(Scanner lectorConsola, AlmacenDispositivos almacen) {
        try {

            System.out.println("Introduzca el código del dispositivo:");
            String codigo = lectorConsola.nextLine();

            System.out.println("Introduzca el nombre del dispositivo:");
            String nombre = lectorConsola.nextLine();

            System.out.println("Introduzca el tipo del dispositivo:");
            String tipo = lectorConsola.nextLine();

            Dispositivo dispositivoAlta = new Dispositivo(codigo, nombre, tipo);

            boolean operacionExitosa = almacen.altaDispositivo(dispositivoAlta);

            if (operacionExitosa == false) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException errorDeInsercion) {
            System.out.println(
                    "No se ha podido dar de alta el dispositivo, revise que no haya un dispositivo con ese código y que haya espacio en el almacén.");
        } catch (Exception errorDeLectura) {
            System.out.println("Error al leer por consola, por favor inténtelo de nuevo.");
        }
    }

    private static void registrarSesion(Scanner lectorConsola, AlmacenDispositivos almacen) {
        try {

            System.out.println("Por favor introduzca el código del dispositivo:");
            String codigo = lectorConsola.nextLine();

            Dispositivo dispositivoRegistro = almacen.buscarPorCodigo(codigo);
            if (dispositivoRegistro == null) {
                throw new IllegalArgumentException("Dispositivo no registrado en el inventario.");
            }

            System.out.println("Dispositivo encontrado. Por favor introduzca el número de horas de uso:");
            double horas = leerDouble(lectorConsola);
            if (horas <= 0) {
                throw new IllegalArgumentException("Las horas tienen que ser mayores que 0.");
            }

            System.out.println("Introduzca el consumo:");
            double consumo = leerDouble(lectorConsola);
            if (consumo < 0) {
                throw new IllegalArgumentException("El consumo tiene que ser positivo.");
            }

            System.out.println("Introduzca la temperatura máxima:");
            double maxTemp = leerDouble(lectorConsola);
            if (maxTemp < 0) {
                throw new IllegalArgumentException("La temperatura máxima tiene que ser positiva.");
            }

            SesionUso nuevaSesion = new SesionUso(horas, consumo, maxTemp);
            dispositivoRegistro.registrarSesion(nuevaSesion);

        } catch (IllegalArgumentException argumentoInvalido) {
            System.out.println(argumentoInvalido.getMessage());
        } catch (Exception e) {
            System.out.println("Error al leer por consola, por favor inténtelo de nuevo.");
        }
    }

    private static void mostrarInfoDispositivo(Scanner lectorConsola, AlmacenDispositivos almacen) {
        try {
            System.out.println("Por favor introduzca el código del dispositivo.");
            String codigo = lectorConsola.nextLine();

            Dispositivo dispositivoInfo = almacen.buscarPorCodigo(codigo);
            if (dispositivoInfo == null) {
                throw new IllegalArgumentException("Dispositivo no registrado en el inventario");
            }

            System.out.println(dispositivoInfo.toString());
            dispositivoInfo.mostrarSesiones();

        } catch (IllegalArgumentException argumentoInvalido) {
            System.out.println(argumentoInvalido.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura, por favor inténtelo de nuevo");
        }

    }

    private static void listarDispositivos(AlmacenDispositivos almacen) {
        almacen.listarDispositivos();
    }

    private static void mostrarEstadisticas(AlmacenDispositivos almacen) {
        System.out.println("Media global de consumo: " + String.format("%.2f", almacen.mediaGlobalConsumo()));
        Dispositivo dispositivoMasUsado = almacen.dispositivoMasUsado();
        if (dispositivoMasUsado == null) {
            System.out.println("No hay dispositivos en el almacén.");
        } else {
            System.out.println(dispositivoMasUsado.toString());
        }

    }

}