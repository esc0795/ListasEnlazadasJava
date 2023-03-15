import java.util.Scanner;

public class main {
    listaVagones lista = new listaVagones();
    String tipoFruta = "";
    int kilos = 0, ciudad = 0, numeroVagon = 0, kilosDescarga = 0;

    public static void main(String[] args) {
        main main = new main();
        Scanner ent = new Scanner(System.in);

        System.out.println("Bienvenido a la estacion de carga/descarga de frutas de la ciudad: ");
        System.out.println("Ingrese numero segun requiera: ");
        System.out.println(">> Cargar fruta: 1 << || >> Descargar fruta: 2 << || >> SALIR: 0 <<");
        int opcion = ent.nextInt();

        while (opcion > 0 && main.ciudad < 10) {
            if (opcion == 1) {
                main.cargar();
                System.out.println("Bienvenido a la estacion de carga/descarga de frutas de la ciudad: ");
                System.out.println("Ingrese numero segun requiera: ");
                System.out.println(">> Cargar fruta: 1 << || >> Descargar fruta: 2 << || >> SALIR: 0 <<");
                opcion = ent.nextInt();
            } else {
                main.descargar();
                System.out.println("Bienvenido a la estacion de carga/descarga de frutas de la ciudad: ");
                System.out.println("Ingrese numero segun requiera: ");
                System.out.println(">> Cargar fruta: 1 << || >> Descargar fruta: 2 << || >> SALIR: 0 <<");
                opcion = ent.nextInt();
            }
        }
    }

    public void cargar() {
        Scanner ent = new Scanner(System.in);
        fruta fruta = new fruta(numeroVagon, ciudad, tipoFruta, kilos);

        System.out.println("Ingrese tipo de fruta a cargar: ");
        tipoFruta = ent.nextLine();
        System.out.println("Ingrese cantidad de kilos de carga:");
        kilos = ent.nextInt();

        ciudad = fruta.getCiudad() + 1;
        numeroVagon = fruta.getNumeroVagon() + 1;

        fruta.setCiudad(ciudad);
        fruta.setNumeroVagon(numeroVagon);
        fruta.setKilos(kilos);
        fruta.setTipoFruta(tipoFruta);
        if(fruta.getNumeroVagon() == 0) {
            lista.insertarPrimero(fruta);
        } else {
            lista.insertarFinal(fruta);
        }
        lista.mostrarData(fruta);
    }

    public void descargar() {
        Scanner ent = new Scanner(System.in);
        fruta fruta = new fruta(numeroVagon, ciudad, tipoFruta, kilos);

        System.out.println("Ingrese numero de vagon a descargar: ");
        numeroVagon = ent.nextInt();
        System.out.println("Ingrese cantidad de kilos de descarga:");
        kilosDescarga = ent.nextInt();

        lista.descargarVagon(numeroVagon, fruta, kilosDescarga);
        lista.mostrarData(fruta);
    }
}
