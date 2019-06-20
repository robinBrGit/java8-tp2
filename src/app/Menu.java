package app;

import util.GestionList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        GestionList.init();
        GestionList.fillDates();
        GestionList.fillTimes();
        int choix = 0;
        Scanner scan = new Scanner(System.in);
        while (choix != 10) {
            System.out.println("MENU PRINCIPALE");
            System.out.println("1. Ajouter une nouvelle date");
            System.out.println("2. Ajouter un nouveau temps");
            System.out.println("3. Ajouter une date et un temps");
            System.out.println("4. Afficher les liste");
            System.out.println("5. Afficher différence entre");
            choix = scan.nextInt();
            switch (choix) {
                case 1:
                    addDate(scan);
                    break;
                case 2:
                    addTime(scan);
                    break;
                case 3:
                    addDateTime(scan);
                    break;
                case 4:
                    listMenu(scan);
                    break;
                case 5:
                    diffMenu(scan);
                    break;
                case 10:
                    System.out.println("Fermeture de l'application");
                    break;
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;
            }
        }
        scan.close();
    }
    /* -----------Ajout--------------- */
    //region Ajout
    private static void addDate(Scanner scan) {
        int year = 0, month = 0, day = 0;
        boolean ok = false;
        while (!ok) {
            System.out.println("Entrer L'année :");
            year = scan.nextInt();
            scan.nextLine();
            if (year > 0 && year <= LocalDate.now().getYear())
                ok = true;
            else System.out.println("L'année doit etre entre 0 et " + LocalDate.now().getYear());
        }
        ok = false;
        while (!ok) {
            System.out.println("Entrer le mois :");
            month = scan.nextInt();
            scan.nextLine();
            if (month > 0 && month <= 12)
                ok = true;
            else System.out.println("Le mois doit etre compri entre 1 et 12 inclu");
        }
        ok = false;
        LocalDate testDay = LocalDate.of(year, month, 1);
        while (!ok) {
            System.out.println("Entrer le jour");
            day = scan.nextInt();
            scan.nextLine();
            if (day > 0 && day <= testDay.lengthOfMonth())
                ok = true;
            else System.out.println("Le jour doit etre compri entre 1 et " + testDay.lengthOfMonth());
        }

        LocalDate ld = LocalDate.of(year, month, day);
        GestionList.getDates().add(ld);
    }
    private static void addTime(Scanner scan) {
        int hours = 0, minit = 0, sec = 0;
        boolean ok = false;
        while (!ok) {
            System.out.println("Entrer L'heure :");
            hours = scan.nextInt();
            scan.nextLine();
            if (hours >= 0 && hours < 24)
                ok = true;
            else System.out.println("L'heure doit etre 0 et 23 inclu");
        }
        ok = false;
        while (!ok) {
            System.out.println("Entrer les minutes :");
            minit = scan.nextInt();
            scan.nextLine();
            if (minit >= 0 && minit < 60)
                ok = true;
            else System.out.println("Les minutes doivent etre comprise entre 0 et 59 inclu");
        }
        ok = false;
        while (!ok) {
            System.out.println("Entrer les seconde :");
            sec = scan.nextInt();
            scan.nextLine();
            if (sec >= 0 && sec < 60)
                ok = true;
            else System.out.println("Les seconde doivent etre comprise entre 0 et 59 inclu");
        }
        LocalTime lt = LocalTime.of(hours, minit, sec);
        GestionList.getTimes().add(lt);
    }
    private static void addDateTime(Scanner scan) {
        int year = 0, month = 0, day = 0;
        int hours = 0, minit = 0, sec = 0;
        boolean ok = false;
        while (!ok) {
            System.out.println("Entrer L'année :");
            year = scan.nextInt();
            scan.nextLine();
            if (year > 0 && year <= LocalDate.now().getYear())
                ok = true;
            else System.out.println("L'année doit etre entre 0 et " + LocalDate.now().getYear());
        }
        ok = false;
        while (!ok) {
            System.out.println("Entrer le mois :");
            month = scan.nextInt();
            scan.nextLine();
            if (month > 0 && month <= 12)
                ok = true;
            else System.out.println("Le mois doit etre compri entre 1 et 12 inclu");
        }
        ok = false;
        LocalDate testDay = LocalDate.of(year, month, 1);
        while (!ok) {
            System.out.println("Entrer le jour");
            day = scan.nextInt();
            scan.nextLine();
            if (day > 0 && day <= testDay.lengthOfMonth())
                ok = true;
            else System.out.println("Le jour doit etre compri entre 1 et " + testDay.lengthOfMonth());
        }
        ok = false;
        while (!ok) {
            System.out.println("Entrer L'heure :");
            hours = scan.nextInt();
            scan.nextLine();
            if (hours >= 0 && hours < 24)
                ok = true;
            else System.out.println("L'heure doit etre 0 et 23 inclu");
        }
        ok = false;
        while (!ok) {
            System.out.println("Entrer les minutes :");
            minit = scan.nextInt();
            scan.nextLine();
            if (minit >= 0 && minit < 60)
                ok = true;
            else System.out.println("Les minutes doivent etre comprise entre 0 et 59 inclu");
        }
        ok = false;
        while (!ok) {
            System.out.println("Entrer les seconde :");
            sec = scan.nextInt();
            scan.nextLine();
            if (sec >= 0 && sec < 60)
                ok = true;
            else System.out.println("Les seconde doivent etre comprise entre 0 et 59 inclu");
        }
        LocalDateTime ldt = LocalDateTime.of(year, month, day, hours, minit, sec);
        GestionList.getDateTimes().add(ldt);
    }
    //endregion Ajout
    /*------------Menu des Listes---------- */
    private static void listMenu(Scanner scan) {
        int choix = 0;
        while (choix != 4) {
            System.out.println("MENU LISTE");
            System.out.println("1. Afficher la liste des dates");
            System.out.println("2. Afficher la liste des temps");
            System.out.println("3. Afficher la liste des dates avec temps");
            System.out.println("4. Revenir au menu principale");
            choix = scan.nextInt();
            switch (choix) {
                case 1:
                    dateMenu(scan);
                    break;
                case 2:
                    timeMenu(scan);
                    break;
                case 3:
                    dateTimeMenu(scan);
                    break;
                case 4:
                    System.out.println("Fermeture de l'application");
                    break;
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;
            }
        }
    }
    /* ----------Menu Date------------------- */
    //region Date
    private static void dateMenu(Scanner scan) {
        int choix = 0;
        while (choix != 4) {
            System.out.println("1. Afficher les dates");
            System.out.println("2. Filtrer les dates");
            System.out.println("3. Trier les dates");
            System.out.println("4. Revenir au menu des liste");
            choix = scan.nextInt();
            switch (choix) {
                case 1:
                    showDate();
                    break;
                case 2:
                    dateFilter(scan);
                    break;
                case 3:
                    sortDate(scan);
                case 4:
                    break;
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;
            }
        }
    }
    private static void dateFilter(Scanner scan){
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("filtrer sur :");
            System.out.println("1. l'année");
            System.out.println("2. le mois");
            System.out.println("3. le jour");
            choix = scan.nextInt();
            switch (choix){
                case 1:
                    filterDateByYear(scan);
                    ok=true;
                    break;
                case 2:
                    filterDateByMonth(scan);
                    ok=true;
                    break;
                case 3:
                    filterDateByDay(scan);
                    ok=true;
                    break;
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;
            }
        }

    }

    private static void filterDateByYear(Scanner scan){
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tYear = scan.nextInt();
                    if(tYear < 0 && tYear > LocalDate.now().getYear())break;
                    final int year = tYear;
                    GestionList.getDates().stream()
                            .filter(d->d.getYear()> year)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tYear = scan.nextInt();
                    if(tYear < 0 && tYear > LocalDate.now().getYear())break;
                    final int year = tYear;
                    GestionList.getDates().stream()
                            .filter(d->d.getYear()< year)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tYear = scan.nextInt();
                    if(tYear < 0 && tYear > LocalDate.now().getYear())break;
                    final int year = tYear;
                    GestionList.getDates().stream()
                            .filter(d->d.getYear()== year)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }
    private static void filterDateByMonth(Scanner scan){
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tMonth = scan.nextInt();
                    if(tMonth < 1 && tMonth > 12)break;
                    final int month = tMonth;
                    GestionList.getDates().stream()
                            .filter(d->d.getMonth().getValue() > month )
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tMonth = scan.nextInt();
                    if(tMonth < 1 && tMonth > 12)break;
                    final int month = tMonth;
                    GestionList.getDates().stream()
                            .filter(d->d.getMonth().getValue()< month)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tMonth = scan.nextInt();
                    if(tMonth < 1 && tMonth > 12)break;
                    final int month = tMonth;
                    GestionList.getDates().stream()
                            .filter(d->d.getMonth().getValue() == month)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }
    private static void filterDateByDay(Scanner scan){
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tDay = scan.nextInt();
                    if(tDay < 1 && tDay > 31)break;
                    final int day = tDay;
                    GestionList.getDates().stream()
                            .filter(d->d.getDayOfMonth() > day )
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tDay = scan.nextInt();
                    if(tDay < 1 && tDay > 31)break;
                    final int day = tDay;
                    GestionList.getDates().stream()
                            .filter(d->d.getDayOfMonth()< day)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tDay = scan.nextInt();
                    if(tDay < 1 && tDay > 31)break;
                    final int day = tDay;
                    GestionList.getDates().stream()
                            .filter(d->d.getDayOfMonth() == day)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }
    private static void showDate(){
        GestionList.getDates().stream()
                .forEach(d -> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }
    private static void sortDate(Scanner scan) {
        int choix = 0;
        boolean ok=false;
        while (!ok){
            System.out.println("Trier sur :");
            System.out.println("1. l'année");
            System.out.println("2. le mois");
            System.out.println("3. le jour");
            choix= scan.nextInt();
            switch (choix){
                case 1:
                    GestionList.getDates().stream()
                            .sorted(Comparator.comparing(LocalDate::getYear))
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                case 2:
                    GestionList.getDates().stream()
                            .sorted(Comparator.comparing(LocalDate::getMonth))
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                case 3:
                    GestionList.getDates().stream()
                            .sorted(Comparator.comparing(LocalDate::getDayOfMonth))
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;

            }
        }
    }
    //endregion Date
    /*-----------Menu Time--------------------*/
    //region Time
    private static void timeMenu(Scanner scan){
        int choix = 0;
        while (choix != 4) {
            System.out.println("1. Afficher les temps");
            System.out.println("2. Filtrer les temps");
            System.out.println("3. Trier les temps");
            System.out.println("4. Revenir au menu des liste");
            choix = scan.nextInt();
            switch (choix) {
                case 1:
                    showTime();
                    break;
                case 2:
                    timeFilter(scan);
                    break;
                case 3:
                    sortTime(scan);
                case 4:
                    break;
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;
            }
        }
    }

    private static void sortTime(Scanner scan) {
        int choix = 0;
        boolean ok=false;
        while (!ok){
            System.out.println("Trier sur :");
            System.out.println("1. l'heure");
            System.out.println("2. les minutes");
            System.out.println("3. les secondes");
            choix= scan.nextInt();
            switch (choix){
                case 1:
                    GestionList.getTimes().stream()
                            .sorted(Comparator.comparing(LocalTime::getHour)
                                    .thenComparing(Comparator.comparing(LocalTime::getMinute)
                                            .thenComparing(LocalTime::getSecond)))
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                case 2:
                    GestionList.getTimes().stream()
                            .sorted(Comparator.comparing(LocalTime::getMinute))
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                case 3:
                    GestionList.getTimes().stream()
                            .sorted(Comparator.comparing(LocalTime::getSecond))
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;

            }
        }
    }

    private static void timeFilter(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("filtrer sur :");
            System.out.println("1. l'heure");
            System.out.println("2. les minutes");
            System.out.println("3. les secondes");
            choix = scan.nextInt();
            switch (choix){
                case 1:
                    filterTimeByHours(scan);
                    ok=true;
                    break;
                case 2:
                    filterTimeByMinit(scan);
                    ok=true;
                    break;
                case 3:
                    filterTimeBySec(scan);
                    ok=true;
                    break;
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;
            }
        }    }

    private static void filterTimeBySec(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tSec = scan.nextInt();
                    if(tSec < 0 && tSec > 59)break;
                    final int sec = tSec;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour()> sec)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tSec = scan.nextInt();
                    if(tSec < 0 && tSec > 59)break;
                    final int sec = tSec;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour()< sec)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tSec = scan.nextInt();
                    if(tSec < 0 && tSec > 59)break;
                    final int sec = tSec;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour() == sec)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }

    private static void filterTimeByMinit(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tMinit = scan.nextInt();
                    if(tMinit < 0 && tMinit > 59)break;
                    final int minit = tMinit;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour()> minit)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tMinit = scan.nextInt();
                    if(tMinit < 0 && tMinit > 59)break;
                    final int minit = tMinit;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour()< minit)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tMinit = scan.nextInt();
                    if(tMinit < 0 && tMinit > 59)break;
                    final int minit = tMinit;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour() == minit)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }

    private static void filterTimeByHours(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tHour = scan.nextInt();
                    if(tHour < 0 && tHour > 23)break;
                    final int hour = tHour;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour()> hour)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tHour = scan.nextInt();
                    if(tHour < 0 && tHour > 23)break;
                    final int hour = tHour;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour()< hour)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tHour = scan.nextInt();
                    if(tHour < 0 && tHour > 23)break;
                    final int hour = tHour;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour() == hour)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }


    private static void showTime(){
        GestionList.getTimes().stream()
                .forEach(t -> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
    }
    //endregion Time
    /*-----------Menu Date Time---------------*/
    //region DateTime
    private static void dateTimeMenu(Scanner scan){
        int choix = 0;
        while (choix != 4) {
            System.out.println("1. Afficher les dates et temps");
            System.out.println("2. Filtrer les dates et temps");
            System.out.println("3. Trier les dates et temps");
            System.out.println("4. Revenir au menu des liste");
            choix = scan.nextInt();
            switch (choix) {
                case 1:
                    showDateTime();
                    break;
                case 2:
                    dateTimeFilter(scan);
                    break;
                case 3:
                    sortDateTime(scan);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;
            }
        }
    }

    private static void sortDateTime(Scanner scan) {
        int choix = 0;
        boolean ok=false;
        while (!ok){
            System.out.println("Trier sur :");
            System.out.println("1. l'année");
            System.out.println("2. le mois");
            System.out.println("3. le jour");
            System.out.println("4. l'heure");
            System.out.println("5. les minutes");
            System.out.println("6. les secondes");
            choix= scan.nextInt();
            switch (choix){
                case 1:
                    GestionList.getDateTimes().stream()
                            .sorted(Comparator.comparing(LocalDateTime::getYear))
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"))));
                    ok=true;
                    break;
                case 2:
                    GestionList.getDateTimes().stream()
                            .sorted(Comparator.comparing(LocalDateTime::getMonth))
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"))));
                    ok=true;
                    break;
                case 3:
                    GestionList.getDateTimes().stream()
                            .sorted(Comparator.comparing(LocalDateTime::getDayOfMonth))
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"))));
                    ok=true;
                    break;
                case 4:
                    GestionList.getDateTimes().stream()
                            .sorted(Comparator.comparing(LocalDateTime::getHour)
                                    .thenComparing(Comparator.comparing(LocalDateTime::getMinute)
                                            .thenComparing(LocalDateTime::getSecond)))
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"))));
                    ok=true;
                    break;
                case 5:
                    GestionList.getDateTimes().stream()
                            .sorted(Comparator.comparing(LocalDateTime::getMinute))
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"))));
                    ok=true;
                    break;
                case 6:
                    GestionList.getDateTimes().stream()
                            .sorted(Comparator.comparing(LocalDateTime::getSecond))
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"))));
                    ok=true;
                    break;

            }
        }
    }

    private static void dateTimeFilter(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("filtrer sur :");
            System.out.println("1. l'année");
            System.out.println("2. le mois");
            System.out.println("3. le jour");
            System.out.println("4. l'heure");
            System.out.println("5. les minutes");
            System.out.println("6. les secondes");
            
            choix = scan.nextInt();
            switch (choix){
                case 1:
                    filterDateTimeByYear(scan);
                    ok=true;
                    break;
                case 2:
                    filterDateTimeByMonth(scan);
                    ok=true;
                    break;
                case 3:
                    filterDateTimeByDay(scan);
                    ok=true;
                    break;
                case 4:
                    filterDateTimeByHours(scan);
                    ok=true;
                    break;
                case 5:
                    filterDateTimeByMinit(scan);
                    ok=true;
                    break;
                case 6:
                    filterDateTimeBySec(scan);
                    ok=true;
                    break;
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;
            }
        }
    }

    private static void filterDateTimeBySec(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tSec = scan.nextInt();
                    if(tSec < 0 && tSec > 59)break;
                    final int sec = tSec;
                    GestionList.getDateTimes().stream()
                            .filter(t->t.getHour()> sec)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tSec = scan.nextInt();
                    if(tSec < 0 && tSec > 59)break;
                    final int sec = tSec;
                    GestionList.getDateTimes().stream()
                            .filter(t->t.getHour()< sec)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tSec = scan.nextInt();
                    if(tSec < 0 && tSec > 59)break;
                    final int sec = tSec;
                    GestionList.getDateTimes().stream()
                            .filter(t->t.getHour() == sec)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }

    private static void filterDateTimeByMinit(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tMinit = scan.nextInt();
                    if(tMinit < 0 && tMinit > 59)break;
                    final int minit = tMinit;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour()> minit)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tMinit = scan.nextInt();
                    if(tMinit < 0 && tMinit > 59)break;
                    final int minit = tMinit;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour()< minit)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tMinit = scan.nextInt();
                    if(tMinit < 0 && tMinit > 59)break;
                    final int minit = tMinit;
                    GestionList.getTimes().stream()
                            .filter(t->t.getHour() == minit)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }

    private static void filterDateTimeByHours(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tHour = scan.nextInt();
                    if(tHour < 0 && tHour > 23)break;
                    final int hour = tHour;
                    GestionList.getDateTimes().stream()
                            .filter(t->t.getHour()> hour)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tHour = scan.nextInt();
                    if(tHour < 0 && tHour > 23)break;
                    final int hour = tHour;
                    GestionList.getDateTimes().stream()
                            .filter(t->t.getHour()< hour)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tHour = scan.nextInt();
                    if(tHour < 0 && tHour > 23)break;
                    final int hour = tHour;
                    GestionList.getDateTimes().stream()
                            .filter(t->t.getHour() == hour)
                            .forEach(t-> System.out.println(t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }

    private static void filterDateTimeByDay(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tDay = scan.nextInt();
                    if(tDay < 1 && tDay > 31)break;
                    final int day = tDay;
                    GestionList.getDateTimes().stream()
                            .filter(d->d.getDayOfMonth() > day )
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tDay = scan.nextInt();
                    if(tDay < 1 && tDay > 31)break;
                    final int day = tDay;
                    GestionList.getDateTimes().stream()
                            .filter(d->d.getDayOfMonth()< day)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tDay = scan.nextInt();
                    if(tDay < 1 && tDay > 31)break;
                    final int day = tDay;
                    GestionList.getDateTimes().stream()
                            .filter(d->d.getDayOfMonth() == day)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }

    private static void filterDateTimeByMonth(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tMonth = scan.nextInt();
                    if(tMonth < 1 && tMonth > 12)break;
                    final int month = tMonth;
                    GestionList.getDateTimes().stream()
                            .filter(d->d.getMonth().getValue() > month )
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tMonth = scan.nextInt();
                    if(tMonth < 1 && tMonth > 12)break;
                    final int month = tMonth;
                    GestionList.getDateTimes().stream()
                            .filter(d->d.getMonth().getValue()< month)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tMonth = scan.nextInt();
                    if(tMonth < 1 && tMonth > 12)break;
                    final int month = tMonth;
                    GestionList.getDateTimes().stream()
                            .filter(d->d.getMonth().getValue() == month)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }

    private static void filterDateTimeByYear(Scanner scan) {
        int choix = 0;
        boolean ok = false;
        while (!ok){
            System.out.println("1. >");
            System.out.println("2. <");
            System.out.println("3. =");
            choix = scan.nextInt();
            switch (choix){
                case 1:{
                    System.out.println("à");
                    int tYear = scan.nextInt();
                    if(tYear < 0 && tYear > LocalDate.now().getYear())break;
                    final int year = tYear;
                    GestionList.getDateTimes().stream()
                            .filter(d->d.getYear()> year)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 2:{
                    System.out.println("à");
                    int tYear = scan.nextInt();
                    if(tYear < 0 && tYear > LocalDate.now().getYear())break;
                    final int year = tYear;
                    GestionList.getDateTimes().stream()
                            .filter(d->d.getYear()< year)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }

                case 3:{
                    System.out.println("à");
                    int tYear = scan.nextInt();
                    if(tYear < 0 && tYear > LocalDate.now().getYear())break;
                    final int year = tYear;
                    GestionList.getDateTimes().stream()
                            .filter(d->d.getYear()== year)
                            .forEach(d-> System.out.println(d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    ok=true;
                    break;
                }
                default:
                    System.out.println("Je n'ai pas compris la requête");
                    break;

            }
        }
    }


    private static void showDateTime(){
        GestionList.getDateTimes().stream()
                .forEach(dt-> System.out.println(dt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))));
    }
//endregion Datetime

    //-----------Menu difference--------------

    private static void diffMenu(Scanner scan){
        int choix = 0;
        while (choix != 4){
            System.out.println("MENU DIFFERENCE");
            System.out.println("1. difference entre des dates");
            System.out.println("2. difference entre des temps");
            System.out.println("3. difference entre des dates et temps");
            choix = scan.nextInt();

        }
    }

}

