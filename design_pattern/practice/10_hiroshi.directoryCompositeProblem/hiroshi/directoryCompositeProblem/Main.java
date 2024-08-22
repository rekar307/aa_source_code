package hiroshi.directoryCompositeProblem;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            rootdir.printList();
            System.out.println();

            System.out.println("Making bin entries...");
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            bindir.printList();
            System.out.println();

            System.out.println("Making usr entries...");
            Directory Kim = new Directory("Kim");
            Directory Lee = new Directory("Lee");
            Directory Park = new Directory("Park");
            usrdir.add(Kim);
            usrdir.add(Lee);
            usrdir.add(Park);
            Kim.add(new File("diary.html", 100));
            Kim.add(new File("Composite.java", 200));
            Lee.add(new File("memo.tex", 300));
            Park.add(new File("game.doc", 400));
            Park.add(new File("junk.mail", 500));
            usrdir.printList();
            System.out.println();

            // adding a new file
            File file = new File("MyNewFile.java", 2000);
            Kim.add(file);
            rootdir.printList();
            System.out.println();

            System.out.println("file = " + file.getName());     
            System.out.println("Kim = " + Kim.getName());

            // Practice 9
//            System.out.println("file = " + file.getFullName());
//            System.out.println("Kim = " + Kim.getFullName());

        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}

/*
root
  + bin
  |  + vi
  |  + latex
  + tmp
  + usr
     + Kim
     |  + diary.html
     |  + Composite.java
     |  + MyNewFile
     + Lee
     |  + memo.tex
     + Park
       + game.doc
       + junk.mail
 */