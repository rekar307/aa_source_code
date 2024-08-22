package hiroshi.VisitorProblem;


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
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.accept(new PrintListVisitor());

            System.out.println("\nMaking user entries...");
            Directory Kim = new Directory("Kim");
            Directory Lee = new Directory("Lee");
            Directory Park = new Directory("Park");
            usrdir.add(Kim);
            usrdir.add(Lee);
            usrdir.add(Park);
            Kim.add(new File("diary.html", 100));
            Kim.add(new File("Composite.java", 200));
            Lee.add(new File("memo.tex", 300));
            Lee.add(new File("index.html", 350));
            Park.add(new File("game.doc", 400));
            Park.add(new File("junk.mail", 500));
            rootdir.accept(new PrintListVisitor());

            // Practice 12
//            FileFindVisitor ffv = new FileFindVisitor(".html");
//            rootdir.accept(ffv);
//
//            System.out.println("\nHTML files are:");
//            Iterator it = ffv.getFoundFiles();
//            while (it.hasNext()) {
//                File file = (File)it.next();
//                System.out.println(file.toString());
//            }
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}

