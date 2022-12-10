/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenlaboratorio2_joedsosa;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joeds
 */
public class ExamenLaboratorio2_JoedSosa {

    static Scanner sc = new Scanner(System.in);
    static boolean finDelJuego = false;
    static int dias = 1;
    static int conteoDiasCosecha = 5;
    static boolean hayCosechas = false;
    static int plantasEnCosecha = 0;
    static Granja granja = new Granja(500);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InicioJuego();
    }

    public static void InicioJuego() {
        System.out.println("Bienvenido a la granja: Mi Granjita");

        do {
            System.out.println("<----------------- Dia " + dias + " ----------------->");
            if (hayCosechas) {
                conteoDiasCosecha--;
                if (conteoDiasCosecha + 1 <= 0) {
                    System.out.println("Hay plantas disponibles para cosechar");
                } else {
                    System.out.println("Faltal " + (conteoDiasCosecha + 1) + " para que esten listas las cosechas!");
                }

            } else {
                System.out.println("No hay cosechas");
            }
            System.out.println("Que desea hacer?");
            System.out.println("1.- Plantar Cosechas");
            System.out.println("2.- Cosechar las cosechas");
            System.out.println("3.- Conseguir animales");
            System.out.println("4.- Vender cosas");
            System.out.println("5.- Dormir");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            if (op > 0 && op < 6) {
                switch (op) {
                    case 1: {
                        plantarCosechas();
                        break;
                    }
                    case 2: {
                        cosecharPlantas();
                        break;
                    }
                    case 3: {
                        comprarAnimales();
                        break;
                    }
                    case 4: {
                        venderCosas();
                        break;
                    }
                    case 5: {
                        dormir();
                        break;
                    }

                }
                System.out.println("<----------------- FIN DEL DIA ----------------->");
            } else {
                System.out.println("Opcion Incorrecta");
            }
            boolean esMillonario = hayMuchoDinero();
            if (esMillonario) {
                System.out.println("Tienes demasiado dinero como para casarte");
                System.out.println("Deseas Casarte?");
                System.out.println("1.- SI");
                System.out.println("2.- NO");
                Scanner sc3 = new Scanner(System.in);
                int opFinal = sc3.nextInt();
                if (opFinal == 1) {
                    finDelJuego = true;
                }
            }
            dias++;
        } while (!finDelJuego);
        System.out.println("<----------------- FIN DEL JUEGO ----------------->");
    }

    public static void plantarCosechas() {
        Scanner sc = new Scanner(System.in);
        if (!hayCosechas) {
            System.out.println("Cuentas Plantas va a cosechar?");
            int plantasParaCosechar = sc.nextInt();
            plantasEnCosecha = plantasParaCosechar;
            hayCosechas = true;
            conteoDiasCosecha = 5;
            System.out.println("Las cosechas tardan 5 dias en estar");
        } else {
            System.out.println("Tiene una cosecha pendiente le quedan " + (conteoDiasCosecha + 1) + " dias");
            conteoDiasCosecha++;
            dias--;
        }

    }

    public static void dormir() {
        System.out.println("DESCANZANDO Zzzz... ");
    }

    public static boolean hayMuchoDinero() {
        boolean muchoDinero = false;
        if (granja.getSizeListVegetales() > 5 && granja.getSizeListConejos() > 5 && granja.getSizeListVacas() > 5 && granja.getMonets() > 1000) {
            muchoDinero = true;
        }
        return muchoDinero;
    }

    public static void cosecharPlantas() {
        if (!hayCosechas) {
            System.out.println("NO TIENE COSECHAS PENDIENTES");
        } else {
            if (conteoDiasCosecha > 0) {
                System.out.println("LAS COSECHAS NO ESTAN LISTAS");
            } else {
                hayCosechas = false;
                System.out.println("HA COSECHADO " + plantasEnCosecha + " PLANTAS");
                List<Vegetal> vegetalesActuales = granja.getVegetalList();
                for (int i = 0; i < plantasEnCosecha; i++) {
                    Vegetal vegetal = new Vegetal();
                    vegetalesActuales.add(vegetal);
                }
                granja.setVegetalList(vegetalesActuales);
            }
        }
    }

    public static void venderCosas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que desea vender?");
        System.out.println("<----------------- ANALISIS DE LA GRANJA ----------------->");
        System.out.println(granja.printGranja());
        System.out.println("Selecciona");
        System.out.println("1.- Vegetales precio 100 Monets");
        System.out.println("2.- Conejos precio 170 Monets");
        System.out.println("3.- Vacas precio 400 Monets");
        int op = sc.nextInt();
        if (op == 1) {
            if (granja.getSizeListVegetales() > 0) {
                System.out.println("La cantidad de vegetales es: " + granja.getSizeListVegetales());
                System.out.println("Ingrese la cantidad a vender");
                Scanner sc1 = new Scanner(System.in);
                int cantidadVender = sc1.nextInt();
                if (cantidadVender <= granja.getSizeListVegetales()) {
                    System.out.println("Se han vendido " + cantidadVender + " Vegetales");
                    int numVegetales = granja.getSizeListVegetales();
                    for (int i = 0; i < numVegetales; i++) {
                        granja.getVegetalList().remove(0);
                    }
                    int monets = granja.getMonets() + (cantidadVender * 100);
                    granja.setMonets(monets);
                    System.out.println("Tu nueva cantidad de dinero es: " + granja.getMonets());
                }
            } else {
                System.out.println("NO TIENE VEGETALES PARA VENDER");
            }
        } else if (op == 2) {
            if (granja.getSizeListConejos() > 0) {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("La cantidad de conejos es: " + granja.getSizeListConejos());
                System.out.println("Y SUS NOMBRE SON:");
                List<Conejo> conejosActuales = granja.getConejoList();
                for (Conejo conejos : conejosActuales) {
                    System.out.println(conejos.getNombre());
                }
                System.out.println("Ingrese la cantidad a vender");
                int cantidadVender = sc2.nextInt();
                if (cantidadVender <= granja.getSizeListConejos()) {
                    int numConejos = granja.getSizeListConejos();
                    for (int i = 0; i < numConejos; i++) {
                        System.out.println("Bye bye " + granja.getConejoList().get(i).getNombre());
                    }
                    for (int i = 0; i < numConejos; i++) {
                        granja.getConejoList().remove(0);
                    }
                    int monets = granja.getMonets() + (cantidadVender * 170);
                    granja.setMonets(monets);
                    System.out.println("Tu nueva cantidad de dinero es: " + granja.getMonets());
                } else {
                    System.out.println("No puede vender mas conejos de los que tiene");
                }
            } else {
                System.out.println("NO TIENE CONEJOS PARA VENDER");
            }
        } else if (op == 3) {
            if (granja.getSizeListVacas() > 0) {
                System.out.println("La cantidad de vacas es: " + granja.getSizeListVacas());
                System.out.println("Y SUS NOMBRE SON:");
                List<Vaca> vacasActuales = granja.getVacaList();
                for (Vaca vaca : vacasActuales) {
                    System.out.println(vaca.getNombre());
                }
                System.out.println("Ingrese la cantidad a vender");
                Scanner sc1 = new Scanner(System.in);
                int cantidadVender = sc1.nextInt();
                if (cantidadVender <= granja.getSizeListVacas()) {
                    int numVacas = granja.getSizeListConejos();
                    for (int i = 0; i < numVacas; i++) {
                        System.out.println("Bye bye " + granja.getVacaList().get(i).getNombre());
                    }
                    for (int i = 0; i < numVacas; i++) {
                        granja.getVacaList().remove(0);
                    }
                    int monets = granja.getMonets() + (cantidadVender * 400);
                    granja.setMonets(monets);
                    System.out.println("Tu nueva cantidad de dinero es: " + granja.getMonets());
                } else {
                    System.out.println("No puede vender mas vacas de las que tiene");
                }
            } else {
                System.out.println("NO TIENE VACAS PARA VENDER");
            }
        } else {
            System.out.println("Opcion incorrecta");
        }
    }

    public static void comprarAnimales() {
        System.out.println("Cantidad de dinero actual " + granja.getMonets());
        if (granja.getMonets() > 0) {
            System.out.println("Que animales Desea?");
            System.out.println("1.- Conejos -> 150 Monets");
            System.out.println("2.- Vacas   -> 350 Monets");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            if (op == 1) {
                System.out.println("Cuentos Conejos desea?");
                int numConejos = sc.nextInt();
                if ((numConejos * 150) < granja.getMonets()) {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Conejos comprados $$$");
                    List<Conejo> conejosActuales = granja.getConejoList();
                    for (int i = 0; i < numConejos; i++) {
                        Conejo conejo = new Conejo();
                        System.out.println("Ingrese el nombre de su nuevo conejo:");
                        String nombre = sc1.nextLine();
                        conejo.setNombre(nombre);
                        conejosActuales.add(conejo);
                    }
                    int monets = granja.getMonets() - (numConejos * 150);
                    granja.setMonets(monets);
                    System.out.println("Tu nueva cantidad de dinero es: " + granja.getMonets());
                    granja.setConejoList(conejosActuales);
                } else {
                    System.out.println("ERES DEMASIADO POBRE PARA COMPRAR TANTOS!");
                }
            } else if (op == 2) {
                System.out.println("Cuentas Vacas desea?");
                int numVacas = sc.nextInt();
                if ((numVacas * 350) < granja.getMonets()) {
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Vacas compradas $$$");
                    List<Vaca> vacasActuales = granja.getVacaList();
                    for (int i = 0; i < numVacas; i++) {
                        Vaca vaca = new Vaca();
                        System.out.println("Ingrese el nombre de su nueva vaca:");
                        String nombre = sc2.nextLine();
                        vaca.setNombre(nombre);
                        vacasActuales.add(vaca);
                    }
                    int monets = granja.getMonets() - (numVacas * 350);
                    granja.setMonets(monets);
                    System.out.println("Tu nueva cantidad de dinero es: " + granja.getMonets());
                    granja.setVacaList(vacasActuales);
                } else {
                    System.out.println("ERES DEMASIADO POBRE PARA COMPRAR TANTOS!");
                }
            } else {
                System.out.println("Opcion incorrecta");
            }
        }
    }
}
