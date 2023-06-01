//import java.util.HashSet;
//
//class Automobil {
//    private String marca;
//    public Automobil(String marca) {
//        this.marca = marca;
//    }
//    public int hashCode() {
//        return 0;
//    }
//    public boolean equals(Object obj) {
//        return true;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        HashSet<Automobil> la = new HashSet<>();
//        la.add(new Automobil("BMW"));
//        la.add(new Automobil("Audi"));
//        la.add(new Automobil("BMW"));
//        la.add(new Automobil("Opel"));
//        System.out.println(la.size());
//    }
//}

//class A {
//    public static void metoda(String s) {
//        System.out.print("A" + s);
//    }
//}
//
//class B extends A {
//    public static void metoda(String s) {
//        System.out.print("B" + s);
//    }
//    public void metoda(String s, String t) {
//        System.out.print("B" + s + t);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        A ob = new B();
//        ob.metoda("P");
//        ob.metoda("Q", "R");
//
//    }
//}

//import java.io.*;
//import java.sql.SQLOutput;
//
//class Persoana implements Serializable {
//    String nume;
//    int varsta;
//
//    public Persoana(String nume, int varsta) {
//        this.nume = nume;
//        this.varsta = varsta;
//        System.out.println("Constructor");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persoana.ser"));
//        Persoana p = new Persoana("Ion", 20), q = p;
//        oos.writeObject(q);
//        oos.close();
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persoana.ser"));
//        Persoana r = (Persoana) ois.readObject();
//        ois.close();
//    }
//}

//class Test {
//    static String sir = "A";
//    void A() {
//        try {
//            sir += "B";
//            B();
//        } catch (Exception e) {
//            sir += "C";
//        }
//    }
//
//    void B() throws Exception {
//        try {
//            sir += "D";
//            C();
//        } catch (Exception e) {
//            throw new Exception();
//        } finally {
//            sir += "E";
//        }
//    }
//
//    void C() throws Exception {
//        throw new Exception();
//    }
//
//    public static void main (String[] args) {
//        Test ob = new Test();
//        ob.A();
//        System.out.println(sir);
//    }
//}

//class ABC {
//    public static int x;
//    public int y;
//
//    public ABC() {
//        met();
//    }
//
//    public void met() {
//        x+=3;
//        y+=1;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        ABC t = new ABC();
//        ABC u = new ABC();
//        System.out.println(t.x + u.y);
//    }
//}

//class Test {
//    String str = "a";
//
//    void A() {
//        try {
//            str += "b";
//            B();
//        } catch (Exception e) {
//            str += "c";
//        }
//    }
//
//    void B() throws Exception {
//        try {
//            str += "d";
//            C();
//        } catch (Exception e) {
//            throw new Exception();
//        } finally {
//            str += "e";
//        }
//        str += "f";
//    }
//
//    void C() throws Exception {
//        throw new Exception();
//    }
//
//    public static void main (String[] args) {
//        Test test = new Test();
//        test.A();
//        System.out.println(test.str);
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        String s = new String("Examen");
//        if (s == "Examen") {
//            System.out.println("A");
//        } else {
//            System.out.println("B");
//        }
//        if (s.equals("Examen")) {
//            System.out.println("C");
//        } else {
//            System.out.println("D");
//        }
//    }
//}

//class A {
//    public int x = 1;
//    void afisare()  {
//        System.out.println(x);
//    }
//
//}
//
//class B extends A {
//    public int x = 2;
//    void afisare() {
//        System.out.println(x);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        A ob = new B();
//        System.out.println(++ob.x);
//    }
//}

//class Tablou {
//    static void met(int[] a, int b) {
//        int aux;
//        aux = a[0];
//        a[0] = b;
//        b = aux;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        int b = 6;
//        Tablou.met(a, b);
//        int s = b;
//        for (int i = 0; i < a.length; i++) {
//            s += a[i];
//        }
//        System.out.println(s);
//    }
//}

//class C {
//    public static int a = 1;
//    public int b = 1;
//
//    public void met() {
//        a++;
//        b++;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        C ob1 = new C();
//        C ob2 = new C();
//        ob1.met();
//        ob2.met();
//        System.out.println(ob1.a + ob2.b);
//    }
//}

//class C {
//    public static void met() throws Exception {
//        try {
//            throw new Exception();
//        } finally {
//            System.out.println("M");
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            C.met();
//        } catch (Exception e) {
//            System.out.println("C");
//        } finally {
//            System.out.println("F");
//        }
//        System.out.println("T");
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        String s = "abracadabra";
//        //          012345678910
//        s.replace('r','R');
//        int p = s.indexOf("R");
//        int q = s.lastIndexOf("b");
//        s = s.substring(0, q-p);
//        System.out.println(s);
//        System.out.println(s.length());
//    }
//}

//class B {
//    static String x = "";
//    public static void met_1() {
//        x += "A";
//    }
//
//    public void met_2() {
//        x += "B";
//    }
//
//}
//
//class C extends B {
//    public static void met_1() {
//        x += "C";
//    }
//
//    public void met_2() {
//        x += "D";
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        B ob = new C();
//        ob.met_1();
//        ob.met_2();
//        System.out.println(ob.x);
//    }
//}

//class C {
//    public int a;
//    public static int b;
//    public C() {
//        b++;
//        b=b+a;
//    }
//    public void met() {
//        a = a+b;
//        a++;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        C ob1 = new C(); // b=1
//        ob1.met(); // a=2
//        C ob2 = new C(); // b=2
//        ob2.met(); // a=3
//        System.out.println(ob1.a + ob2.b);
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        String s = "academician";
//        int p = s.lastIndexOf("c");
//        int q = s.indexOf(s.charAt(p));
//        s = s.substring(q, p);
//        System.out.println(s);
//    }
//}

//class C {
//    public static void met_1() throws Exception {
//        try {
//            throw new Exception();
//        } finally {
//            System.out.println("A");
//        }
//    }
//
//    public static void met_2() throws Exception {
//        try {
//            met_1();
//        }
//        catch (Exception ex) {
//            System.out.println("B");
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            C.met_2();
//        } catch (Exception e) {
//            System.out.println("C");
//        } finally {
//            System.out.println("D");
//        }
//        System.out.println("E");
//    }
//}

//class B {
//    public B() {
//        System.out.println("A");
//    }
//    public void met() {
//        System.out.println("B");
//    }
//}
//
//class C extends B {
//    public C() {
//        System.out.println("C");
//    }
//    public void met() {
//        System.out.println("D");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        B ob = new C();
//        ob.met();
//    }
//}

//class Sir {
//    private String sir;
//    public Sir(String sir) {
//        this.sir = sir;
//    }
//    public void modificaSir(String sir) {
//        this.sir = sir;
//    }
//    public void modificaSir(Sir sir) {
//        sir = new Sir("Mihai");
//    }
//    public String getSir() {
//        return sir;
//    }
//}
//
//public class Main {
//    public static void main (String [] args) {
//        Sir s = new Sir("Ion");
//        Sir t = new Sir("Alex");
//        s.modificaSir("Matei");
//        t.modificaSir(new Sir("Dan"));
//        s.modificaSir(t);
//        System.out.println(s.getSir() + " " + t.getSir());
//    }
//}

//class Calcul_1 {
//    void calcul (int a, int b) {
//        System.out.println(a + b + " ");
//    }
//}
//
//class Calcul_2 extends Calcul_1{
//    void calcul (int a, int b) {
//        System.out.println(a - b + " ");
//    }
//}
//
//class Calcul_3 extends Calcul_2{
//    void calcul (int a, int b) {
//        System.out.println(a * b + " ");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Calcul_1 x = new Calcul_3();
//        x.calcul(1,2);
//        Calcul_2 y = (Calcul_2) x;
//        y.calcul(3,4);
//        Calcul_3 z = (Calcul_3) y;
//        z.calcul(5,6);
//    }
//}
//
//public class Main {
//    public static void main (String [] args) {
//        int x=0;
//        int[] a = {1,2,3,4,5};
//
//        try {
//            a[1]=a[5]/(a[0]-1);
//        } catch (ArithmeticException e) {
//            System.out.println("AE ");
//            x+=6;
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("IOOBE ");
//            x+=5;
//        } catch (RuntimeException e) {
//            System.out.println("RE ");
//            x+=4;
//        } catch (Exception e) {
//            System.out.println("E ");
//            x+=3;
//        } finally {
//            System.out.println("F ");
//            x+=2;
//        }
//        System.out.println(++x);
//    }
//
//}

//class Fir implements Runnable {
//    int x;
//
//    public Fir(int x) {
//        this.x = x;
//    }
//
//    public void run() {
//        for (int i=0; i<10; i++)
//            System.out.println(x);
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        Fir obj1 = new Fir(1);
//        Fir obj2 = new Fir(2);
//        Thread t1 = new Thread(obj1);
//        Thread t2 = new Thread(obj2);
//        t1.start();
//        t2.start();
//        t2.join();
//        System.out.print(3);
//    }
//}

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//
//    public static void main(String[] args) {
//        String fileName = "input.txt";  // Path to the input file
//        int wordLength = 5;             // Length of the words to find
//
//        List<String> words = findWords(fileName, wordLength);
//
//        System.out.println("Words of length " + wordLength + ":");
//        for (String word : words) {
//            System.out.println(word);
//        }
//    }
//
//    public static List<String> findWords(String fileName, int wordLength) {
//        List<String> result = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] words = line.split("\\s+");  // Split the line into words
//
//                for (String word : words) {
//                    if (word.length() == wordLength) {
//                        result.add(word);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Error reading the file: " + e.getMessage());
//        }
//
//        return result;
//    }
//}

//import java.io.*;
//import java.util.*;
//public class Main {
//    static List<Integer> numbers = new ArrayList<>();
//    public static void main(String[] args) {
//        File file = new File("src/ajutor.txt");
//        try {
//            Scanner scanner = new Scanner(file);
//            while(scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] numbersString = line.split(" ");
//                for (String number : numbersString) {
//                    numbers.add(Integer.parseInt(number));
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//        System.out.println(numbers);
//    }
//}

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main (String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Integer n = scanner.nextInt();
//        Set<String> distinct = new HashSet<>();
//        File file = new File("src/ajutor.txt");
//        try {
//            scanner = new Scanner(file);
//            while(scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] sentence = line.split("[\\s\\p{Punct}]+");
//                for (String word : sentence) {
//                    if (word.length() >= n) {
//                        distinct.add(word);
//                    }
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//
//        System.out.println(distinct);
//    }
//}

//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//class Diplomaicenta {
//    private String serie;
//    private String absolvent;
//    private int an;
//    private String facultate;
//    private String specializare;
//    private double medie;
//
//    public Diplomaicenta(String serie, String absolvent, int an, String facultate, String specializare, double medie) {
//        this.serie = serie;
//        this.absolvent = absolvent;
//        this.an = an;
//        this.facultate = facultate;
//        this.specializare = specializare;
//        this.medie = medie;
//    }
//
//    public String getSerie() {
//        return serie;
//    }
//
//    public void setSerie(String serie) {
//        this.serie = serie;
//    }
//
//    public String getAbsolvent() {
//        return absolvent;
//    }
//
//    public void setAbsolvent(String absolvent) {
//        this.absolvent = absolvent;
//    }
//
//    public int getAn() {
//        return an;
//    }
//
//    public void setAn(int an) {
//        this.an = an;
//    }
//
//    public String getFacultate() {
//        return facultate;
//    }
//
//    public void setFacultate(String facultate) {
//        this.facultate = facultate;
//    }
//
//    public String getSpecializare() {
//        return specializare;
//    }
//
//    public void setSpecializare(String specializare) {
//        this.specializare = specializare;
//    }
//
//    public double getMedie() {
//        return medie;
//    }
//
//    public void setMedie(double medie) {
//        this.medie = medie;
//    }
//
//    @Override
//    public String toString() {
//        return "Diplomaicenta{" +
//                "serie='" + serie + '\'' +
//                ", absolvent='" + absolvent + '\'' +
//                ", an=" + an +
//                ", facultate='" + facultate + '\'' +
//                ", specializare='" + specializare + '\'' +
//                ", medie=" + medie +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Diplomaicenta that = (Diplomaicenta) o;
//        return an == that.an &&
//                Double.compare(that.medie, medie) == 0 &&
//                serie.equals(that.serie) &&
//                absolvent.equals(that.absolvent) &&
//                facultate.equals(that.facultate) &&
//                specializare.equals(that.specializare);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = serie.hashCode();
//        result = 31 * result + absolvent.hashCode();
//        result = 31 * result + an;
//        result = 31 * result + facultate.hashCode();
//        result = 31 * result + specializare.hashCode();
//        long temp = Double.doubleToLongBits(medie);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        return result;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // Crearea unei liste cu obiecte Diplomaicenta
//        List <Diplomaicenta> diplome = new ArrayList<>();
//        diplome.add(new Diplomaicenta("S001", "John Doe", 2005, "Facultatea de Informatică", "Informatică", 9.5));
//        diplome.add(new Diplomaicenta("S002", "Jane Smith", 2018, "Facultatea de Informatică", "Calculatoare", 10.0));
//        diplome.add(new Diplomaicenta("S003", "Alice Johnson", 2008, "Facultatea de Informatică", "Informatică", 9.8));
//
//        List<Diplomaicenta> diplomeStream1 = diplome.stream()
//                .filter(d -> d.getAn() > 2000 && d.getAn() < 2010)
//                .sorted((d1, d2) -> Double.compare(d2.getMedie(), d1.getMedie()))
//                .collect(Collectors.toList());
//
//        List<String> specializari2018 = diplome.stream()
//                .filter(d -> d.getFacultate().equals("Facultatea de Informatică") && d.getAn() == 2018)
//                .map(Diplomaicenta::getSpecializare)
//                .distinct()
//                .collect(Collectors.toList());
//
//        List<String> absolventiMedia10 = diplome.stream()
//                .filter(d -> d.getMedie() == 10.0)
//                .map(Diplomaicenta::getAbsolvent)
//                .collect(Collectors.toList());
//
//        long diplomeEliberate = diplome.stream()
//                .filter(d -> d.getSpecializare().equals("Informatică"))
//                .count();
//    }
//}

//
//import java.io.*;
//import java.util.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//class Magazin extends Thread {
//    private String fileName;
//    private String produs;
//    private int pretTotal;
//
//    public Magazin(String fileName, String produs) {
//        this.fileName = fileName;
//        this.produs = produs;
//        this.pretTotal = 0;
//    }
//
//    public String getProdus() {
//        return produs;
//    }
//
//    public int getPretTotal() {
//        return pretTotal;
//    }
//
//    @Override
//    public void run() {
//        try (Scanner scanner = new Scanner(new File(fileName))) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] values = line.split(",");
//                if (values.length == 4) {
//                    this.produs = values[1].trim();
//                    this.pretTotal = Integer.parseInt(values[3].trim()) * Integer.parseInt(values[2].trim());
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Eroare la citirea din fisier");
//        }
//    }
//}
//public class Main {
//    public static void main (String[] args) {
//        String magazin1 = "src/magazin_1.txt";
//        String magazin2 = "src/magazin_2.txt";
//
//        try (Scanner scanner = new Scanner(System.in)) {
//            String productName = scanner.nextLine();
//            Magazin m1 = new Magazin(magazin1, productName);
//            Magazin m2 = new Magazin(magazin2, productName);
//
////            ExecutorService executor = Executors.newFixedThreadPool(2);
////            executor.execute(m1);
////            executor.execute(m2);
////
////            executor.shutdown();
////
////            try {
////                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//
//            m1.start();
//            m2.start();
//            m1.join();
//            m2.join();
//
//            int total1 = m1.getPretTotal();
//            int total2 = m2.getPretTotal();
//            System.out.println(total1 + " " + total2);
//        } catch (Exception e) {
//            System.out.println("Eroare la citirea din terminal");
//        }
//    }
//}

//class Fir implements Runnable{
//    int x;
//    public Fir(int x){
//        this.x = x;
//    }
//    public void run(){
//        for (int i = 0; i < 10; i++) System.out.print(x);
//    }
//    public static void main(String args[]) throws InterruptedException{ Fir obj1 = new Fir(1);
//        Fir obj2 = new Fir(2);
//        Thread t1 = new Thread(obj1);
//        Thread t2 = new Thread(obj2);
//        t1.start();
//        t2.start();
//        t2.join();
//        System.out.print(3);
//    }
//}

public class Main {
    public static void main (String[] args) {
        String s = "Ionel are mere si pereeee!!!";
        String c = "e";
        int x = s.length() - s.replace(c, "").length();
        System.out.println(x);
        System.out.println(s.replace(c, ""));
        System.out.println(s.length());
    }
}