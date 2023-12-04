import javax.swing.ImageIcon;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.imageio.ImageIO;



public class Game extends javax.swing.JFrame {
    
    
    //images utilisées
    
    //logos
    ImageIcon logoImage = new ImageIcon("246195de8d7e46e2bd22d8a0437263d2 (1).png");
    ImageIcon insaLogo = new ImageIcon("logo-coul.png");
    //persos
    ImageIcon toph = new ImageIcon("toph.jpg");
    ImageIcon salameche= new ImageIcon("salameche.jpg");
    ImageIcon carapuce= new ImageIcon("carapuce.jpg");
    ImageIcon vegeta = new ImageIcon("vegeta.jpg");
    ImageIcon pikachu = new ImageIcon("pikachu.png");
    ImageIcon kimi = new ImageIcon("kimi.jpg");
    ImageIcon marchalot = new ImageIcon("Marchalot.png");
    ImageIcon alexandre = new ImageIcon("alex.jpg");
    ImageIcon adam = new ImageIcon("adam.png");
    ImageIcon mj = new ImageIcon("michael.jpg");
    ImageIcon mbappe = new ImageIcon("mbappe.jpeg");
    ImageIcon quentin = new ImageIcon("quentintemp.jpg");
    ImageIcon pesquet = new ImageIcon("pesquet.jpg");
    ImageIcon gaïa = new ImageIcon("gaïa.jpg");
    ImageIcon hades = new ImageIcon("hades.png");
    ImageIcon poseidon = new ImageIcon("poseidon.jpg");
    ImageIcon acteon = new ImageIcon("acteon.jpg");
    ImageIcon zeus = new ImageIcon("zeus.jpg");
    ImageIcon chione = new ImageIcon("chione.jpg");
    ImageIcon cronos = new ImageIcon("cronos.jpg");
    //
    ImageIcon apropos = new ImageIcon("A_propos.png");
    ImageIcon vs = new ImageIcon("vs.png");
    //arènes
    ImageIcon insaImage = new ImageIcon("murInsa.jpg");
    ImageIcon areneTerre = new ImageIcon("areneTerre.jpg");
    ImageIcon areneFeu = new ImageIcon("areneFeu.jpg");
    ImageIcon areneEau = new ImageIcon("areneEau.jpg");
    ImageIcon areneNature = new ImageIcon("areneNature.jpeg");
    ImageIcon areneFoudre = new ImageIcon("areneFoudre.jpg");
    ImageIcon areneGlace = new ImageIcon("areneGlace.jpg");
    ImageIcon areneTemps = new ImageIcon("areneTemps.jpg");
    ImageIcon ISS = new ImageIcon("ISS.jpg");
    ImageIcon sahara = new ImageIcon("maroc-sahara.jpeg");
    ImageIcon eiffel = new ImageIcon("eiffel.jpg");
    ImageIcon windows = new ImageIcon("windows.jpg");
    ImageIcon BMC = new ImageIcon("BMC.jpg");
    ImageIcon konoha = new ImageIcon("konoha.png");
    ImageIcon mj_back = new ImageIcon("mj_back.jpg");
    //variable pour changer l'image selon le personnage
    ImageIcon comb = new ImageIcon();
    //Bordure lors de la sélection
    Border lineborder = BorderFactory.createLineBorder(Color.yellow, 3);
    Border noborder = BorderFactory.createLineBorder(Color.orange, 3);
    Border deadborder = BorderFactory.createLineBorder(Color.red, 3);
    //images utilisées dans les panels règles de jeu
    ImageIcon regle_1 = new ImageIcon("Regles1.PNG");
    ImageIcon regle_2 = new ImageIcon("Regles2.PNG");
    ImageIcon att1 = new ImageIcon("att1.PNG");
    ImageIcon att2 = new ImageIcon("att2.PNG");
    ImageIcon att3 = new ImageIcon("att3.PNG");
    ImageIcon attS = new ImageIcon("attS.PNG");
    ImageIcon soin = new ImageIcon("soin.PNG");
    ImageIcon charger = new ImageIcon("charger.PNG");
    ImageIcon switcher = new ImageIcon("switch.PNG");
    ImageIcon domaine = new ImageIcon("domaine.PNG");

    
    int n = 1; //definir nombre joueurs pair : 2 joueurs/ impair : contre ordi
    int c = 0; //permet de faire choisir à chaque joueur 2 persos tour à tour (limité à 4)
    int s = (int)(Math.random()*14); //entier aléatoire pour placer la scène/arène aléatoirement
    int i = 1; //placer images des combattants choisis
    int j = 1; //créer un nouveau Personnage qu'utilisera le joueur pour combattre
    int a = 0; //permet au joueur 1 de sélectionner le personnage avec lequel combattre
    int b = 0; //permet au joueur 2 de sélectionner le personnage avec lequel combattre
    int clickCh = 1;//pour la dernière sélection 
    //nombre de clicks consécutifs sur le combattant pour le choisir
    int premierClick1 = 0;
    int premierClick2 = 0;
    int premierClick3 = 0;
    int premierClick4 = 0;
    int premierClick5 = 0;
    int premierClick6 = 0;
    int kill_1=0;//score du joueur 1 (le premier à 3 gagne)
    int kill_2=0;//score du joueur 2
    int c3j1 = (int)(Math.random()*14);//entier aléatoire pour choisir le combattant 3 du joueur 1
    int c3j2 = (int)(Math.random()*14);//entier aléatoire pour choisir le combattant 3 du joueur 2
    int charge1 = 0;//entier charge du joueur 1 qui est visualisé sur sa jauge de charge
    int charge2 = 0;
    int sw = 0; //entier qui permet de savoir s'il y a un switch et si oui quel joueur l'a fait(1 ou 2) (0 pour pas de switch)
    int partie = 0;//utilisé pour lancer la musique en boucle qu'au début de la partie uniquement
    int tour = 0;
    String nameJ1;// stocke nom du joueur
    String nameJ2;
    String selectedAttack;
    boolean g = false; //si le jeu a commencé ou pas
    boolean nom1 = false;//si le joueur a entré son nom ou pas encore
    boolean nom2 = false;
    boolean pret1 = false;//si le joueur 1 a choisi un combattant ou pas encore
    boolean pret2 = false;//si le joueur 1 a choisi un combattant ou pas encore
    boolean actif1 = false;//si le joueur a le domaine actif(une attaque)
    boolean actif2 = false;
    boolean active1 = false;// si le joueur a deja activé le domaine avant
    boolean active2 = false;
    boolean att3pret1 = false;//si l'attaque 3 du joueur est prête à être utilisée 
    boolean att3pret2 = false;
    boolean powUpI = true;//?
    //si les combattants sont toujours vivants
    boolean b1j1 = true;
    boolean b2j1 = true;
    boolean b3j1 = true;
    boolean b1j2 = true;
    boolean b2j2 = true;
    boolean b3j2 = true;
    boolean j1perd = true;
    boolean j2perd = true;
    boolean combat = false;
    
    //création des personnages
    Personnage p1_1 = new Personnage(1);
    Personnage p2_1 = new Personnage(1);
    Personnage p3_1 = new Personnage(7+c3j1);
    Personnage p1_2 = new Personnage(1);
    Personnage p2_2 = new Personnage(1);
    Personnage p3_2 = new Personnage(7+c3j2);
    
    Personnage pj1 = new Personnage(3); //Personnage créé pour combattre et qui est à chaque fois remplacé par le personnage choisi
    Personnage pj2 = new Personnage(3);
    
    
    public Game() {
        initComponents();
        
        //placer logos
        logo.setIcon(logoImage);
        insa.setIcon(insaLogo);
        
        //afficher seulement panel Home
        panHome.setVisible(true);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        nombreJoueurs.setText("2");
        jp1.setBackground(Color.white);
        startGame.setEnabled(false);
        
        //supprimer textes parasites
        comb1j1.setText("");
        comb2j1.setText("");
        comb3j1.setText("");
        comb1j2.setText("");
        comb2j2.setText("");
        comb3j2.setText("");
        insa.setText("");
        logo.setText("");
        terreTof.setText("");
        feuTof.setText("");
        eauTof.setText("");
        natureTof.setText("");
        foudreTof.setText("");
        glaceTof.setText("");
        
        //placer arène initiale
        switch (s) {
            case 0 -> panGameImage.setIcon(areneTerre);
            case 1 -> panGameImage.setIcon(areneFeu);
            case 2 -> panGameImage.setIcon(areneEau);
            case 3 -> panGameImage.setIcon(areneNature);
            case 4 -> panGameImage.setIcon(areneFoudre);
            case 5 -> panGameImage.setIcon(areneGlace);
            case 6 -> panGameImage.setIcon(ISS);
            case 7 -> panGameImage.setIcon(sahara);
            case 8 -> panGameImage.setIcon(eiffel);
            case 9 -> panGameImage.setIcon(windows);
            case 10 -> panGameImage.setIcon(BMC);
            case 11 -> panGameImage.setIcon(konoha);
            case 12 -> panGameImage.setIcon(insaImage);
            case 13 -> panGameImage.setIcon(areneTemps);
            default -> {
            }
        }
        
        //placer image combattant 3 joueur 2
        switch (c3j1) {
            case 0 -> comb3j1.setIcon(marchalot);
            case 1 -> comb3j1.setIcon(alexandre);
            case 2 -> comb3j1.setIcon(quentin);
            case 3 -> comb3j1.setIcon(adam);
            case 4 -> comb3j1.setIcon(mbappe);
            case 5 -> comb3j1.setIcon(mj);
            case 6 -> comb3j1.setIcon(pesquet);
            case 7 -> comb3j1.setIcon(gaïa);
            case 8 -> comb3j1.setIcon(hades);
            case 9 -> comb3j1.setIcon(poseidon);
            case 10 -> comb3j1.setIcon(acteon);
            case 11 -> comb3j1.setIcon(zeus);
            case 12 -> comb3j1.setIcon(chione);
            case 13 -> comb3j1.setIcon(cronos);
        }  
        
        //placer image combattant 3 joueur 2
        switch (c3j2) {
            case 0 -> comb3j2.setIcon(marchalot);
            case 1 -> comb3j2.setIcon(alexandre);
            case 2 -> comb3j2.setIcon(quentin);
            case 3 -> comb3j2.setIcon(adam);
            case 4 -> comb3j2.setIcon(mbappe);
            case 5 -> comb3j2.setIcon(mj);
            case 6 -> comb3j2.setIcon(pesquet);
            case 7 -> comb3j2.setIcon(gaïa);
            case 8 -> comb3j2.setIcon(hades);
            case 9 -> comb3j2.setIcon(poseidon);
            case 10 -> comb3j2.setIcon(acteon);
            case 11 -> comb3j2.setIcon(zeus);
            case 12 -> comb3j2.setIcon(chione);
            case 13 -> comb3j2.setIcon(cronos);
        }
        
        
        //placer images et cacher le bouton de jeu dans le panel choix initial
        terreTof.setIcon(toph);
        feuTof.setIcon(salameche);
        eauTof.setIcon(carapuce);
        natureTof.setIcon(vegeta);
        foudreTof.setIcon(pikachu);
        glaceTof.setIcon(kimi);
        combattre.setVisible(false);
        //placer les images des persos dans le panel personnages
        TOPH.setIcon(toph);
        SALAMECHE.setIcon(salameche);
        CARAPUCE.setIcon(carapuce);
        VEGETA.setIcon(vegeta);
        PIKACHU.setIcon(pikachu);
        KIMI.setIcon(kimi);
        ALEXANDRE_LE_GRAND.setIcon(alexandre);
        QUENTIN.setIcon(quentin);
        ADAM.setIcon(adam);
        MBAPPE.setIcon(mbappe);
        MICHAEL_JACKSON.setIcon(mj);
        THOMAS_PESQUET.setIcon(pesquet);
        GAIA.setIcon(gaïa);
        HADES.setIcon(hades);
        POSEIDON.setIcon(poseidon);
        ACTEON.setIcon(acteon);
        ZEUS.setIcon(zeus);
        CHIONE.setIcon(chione);
        CRONOS.setIcon(cronos);
        MARCHALOT.setIcon(marchalot);
        //supprimer le texte qui dérange dans panel personnages
        TOPH.setText("");
        SALAMECHE.setText("");
        CARAPUCE.setText("");
        VEGETA.setText("");
        PIKACHU.setText("");
        KIMI.setText("");
        ALEXANDRE_LE_GRAND.setText("");
        QUENTIN.setText("");
        ADAM.setText("");
        MBAPPE.setText("");
        MICHAEL_JACKSON.setText("");
        THOMAS_PESQUET.setText("");
        GAIA.setText("");
        HADES.setText("");
        POSEIDON.setText("");
        ACTEON.setText("");
        ZEUS.setText("");
        CHIONE.setText("");
        CRONOS.setText("");
        MARCHALOT.setText("");
        //panel à propos
        A_PROPOS.setText("");
        A_PROPOS.setIcon(apropos);
        //image versus
        vsImage.setText("");
        vsImage.setIcon(vs);
        //instructions brèves lors du choix
        instructionsChoixI2.setText("Ici, vous aurez à choisir deux de ");
        instructionsChoixI4.setText("vos trois combattants");
        //désactiver boutton start lors du choix des combattants
        startPanChoix.setEnabled(false);
        //cacher items qui parasites
        powUp1.setVisible(false);
        powUp2.setVisible(false);
        jButton4.setVisible(false);
        jButton3.setVisible(false);
        jComboBox3.setVisible(false);
        //activer musique de lancement 
        music musicObject = new music();
        musicObject.playMusic("aaaa.wav");
        //placer images sur panel règles du jeu
        regles1.setIcon(regle_1);
        regles10.setIcon(regle_2);
        
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        
        jTextField137.setEnabled(false);
        jTextField138.setEnabled(false);
        jTextField139.setEnabled(false);
        jTextField140.setEnabled(false);
        jTextField141.setEnabled(false);
        jTextField142.setEnabled(false);
        jTextField143.setEnabled(false);
        jTextField144.setEnabled(false);
        
        jTextField201.setEnabled(false);
        jTextField202.setEnabled(false);
        jTextField203.setEnabled(false);
        jTextField204.setEnabled(false);
        jTextField205.setEnabled(false);
        jTextField206.setEnabled(false);
        jTextField207.setEnabled(false);
        jTextField208.setEnabled(false);
        
        jTextField185.setEnabled(false);
        jTextField186.setEnabled(false);
        jTextField187.setEnabled(false);
        jTextField188.setEnabled(false);
        jTextField189.setEnabled(false);
        jTextField190.setEnabled(false);
        jTextField191.setEnabled(false);
        jTextField192.setEnabled(false);
        
        jTextField209.setEnabled(false);
        jTextField210.setEnabled(false);
        jTextField211.setEnabled(false);
        jTextField212.setEnabled(false);
        jTextField213.setEnabled(false);
        jTextField214.setEnabled(false);
        jTextField215.setEnabled(false);
        jTextField216.setEnabled(false);
        
        jTextField145.setEnabled(false);
        jTextField146.setEnabled(false);
        jTextField147.setEnabled(false);
        jTextField148.setEnabled(false);
        jTextField149.setEnabled(false);
        jTextField150.setEnabled(false);
        jTextField151.setEnabled(false);
        jTextField152.setEnabled(false);
        
        jTextField217.setEnabled(false);
        jTextField218.setEnabled(false);
        jTextField219.setEnabled(false);
        jTextField220.setEnabled(false);
        jTextField221.setEnabled(false);
        jTextField222.setEnabled(false);
        jTextField223.setEnabled(false);
        jTextField224.setEnabled(false);
        
        jTextField177.setEnabled(false);
        jTextField178.setEnabled(false);
        jTextField179.setEnabled(false);
        jTextField180.setEnabled(false);
        jTextField181.setEnabled(false);
        jTextField182.setEnabled(false);
        jTextField183.setEnabled(false);
        jTextField184.setEnabled(false);
        
        jTextField225.setEnabled(false);
        jTextField226.setEnabled(false);
        jTextField227.setEnabled(false);
        jTextField228.setEnabled(false);
        jTextField229.setEnabled(false);
        jTextField230.setEnabled(false);
        jTextField231.setEnabled(false);
        jTextField232.setEnabled(false);
        
        jTextField153.setEnabled(false);
        jTextField154.setEnabled(false);
        jTextField155.setEnabled(false);
        jTextField156.setEnabled(false);
        jTextField157.setEnabled(false);
        jTextField158.setEnabled(false);
        jTextField159.setEnabled(false);
        jTextField160.setEnabled(false);
        
        jTextField233.setEnabled(false);
        jTextField234.setEnabled(false);
        jTextField235.setEnabled(false);
        jTextField236.setEnabled(false);
        jTextField237.setEnabled(false);
        jTextField238.setEnabled(false);
        jTextField239.setEnabled(false);
        jTextField240.setEnabled(false);
        
        jTextField9.setEnabled(false);
        jTextField10.setEnabled(false);
        jTextField11.setEnabled(false);
        jTextField12.setEnabled(false);
        jTextField13.setEnabled(false);
        jTextField14.setEnabled(false);
        jTextField15.setEnabled(false);
        jTextField16.setEnabled(false);
        
        jTextField241.setEnabled(false);
        jTextField242.setEnabled(false);
        jTextField243.setEnabled(false);
        jTextField244.setEnabled(false);
        jTextField245.setEnabled(false);
        jTextField246.setEnabled(false);
        jTextField247.setEnabled(false);
        jTextField248.setEnabled(false);
        
        jTextField161.setEnabled(false);
        jTextField162.setEnabled(false);
        jTextField163.setEnabled(false);
        jTextField164.setEnabled(false);
        jTextField165.setEnabled(false);
        jTextField166.setEnabled(false);
        jTextField167.setEnabled(false);
        jTextField168.setEnabled(false);
        
        jTextField249.setEnabled(false);
        jTextField250.setEnabled(false);
        jTextField251.setEnabled(false);
        jTextField252.setEnabled(false);
        jTextField253.setEnabled(false);
        jTextField254.setEnabled(false);
        jTextField255.setEnabled(false);
        jTextField256.setEnabled(false);
        
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        
        jTextField257.setEnabled(false);
        jTextField258.setEnabled(false);
        jTextField259.setEnabled(false);
        jTextField260.setEnabled(false);
        jTextField261.setEnabled(false);
        jTextField262.setEnabled(false);
        jTextField263.setEnabled(false);
        jTextField264.setEnabled(false);
        
        jTextField169.setEnabled(false);
        jTextField170.setEnabled(false);
        jTextField171.setEnabled(false);
        jTextField172.setEnabled(false);
        jTextField173.setEnabled(false);
        jTextField174.setEnabled(false);
        jTextField175.setEnabled(false);
        jTextField176.setEnabled(false);
        
        jTextField265.setEnabled(false);
        jTextField266.setEnabled(false);
        jTextField267.setEnabled(false);
        jTextField268.setEnabled(false);
        jTextField269.setEnabled(false);
        jTextField270.setEnabled(false);
        jTextField271.setEnabled(false);
        jTextField272.setEnabled(false);
        
        jTextField201.setEnabled(false);
        jTextField202.setEnabled(false);
        jTextField203.setEnabled(false);
        jTextField204.setEnabled(false);
        jTextField205.setEnabled(false);
        jTextField206.setEnabled(false);
        jTextField207.setEnabled(false);
        jTextField208.setEnabled(false);
        
        jTextField193.setEnabled(false);
        jTextField194.setEnabled(false);
        jTextField195.setEnabled(false);
        jTextField196.setEnabled(false);
        jTextField197.setEnabled(false);
        jTextField198.setEnabled(false);
        jTextField199.setEnabled(false);
        jTextField200.setEnabled(false);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Panel1 = new javax.swing.JPanel();
        jp1 = new javax.swing.JPanel();
        persoLabel = new javax.swing.JLabel();
        jp3 = new javax.swing.JPanel();
        persoLabel1 = new javax.swing.JLabel();
        jp2 = new javax.swing.JPanel();
        persoLabel2 = new javax.swing.JLabel();
        jp4 = new javax.swing.JPanel();
        persoLabel3 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        insa = new javax.swing.JLabel();
        panPersos = new javax.swing.JPanel();
        TOPH = new javax.swing.JLabel();
        KIMI = new javax.swing.JLabel();
        CARAPUCE = new javax.swing.JLabel();
        SALAMECHE = new javax.swing.JLabel();
        VEGETA = new javax.swing.JLabel();
        PIKACHU = new javax.swing.JLabel();
        MARCHALOT = new javax.swing.JLabel();
        ALEXANDRE_LE_GRAND = new javax.swing.JLabel();
        QUENTIN = new javax.swing.JLabel();
        ADAM = new javax.swing.JLabel();
        MBAPPE = new javax.swing.JLabel();
        MICHAEL_JACKSON = new javax.swing.JLabel();
        THOMAS_PESQUET = new javax.swing.JLabel();
        GAIA = new javax.swing.JLabel();
        HADES = new javax.swing.JLabel();
        ACTEON = new javax.swing.JLabel();
        ZEUS = new javax.swing.JLabel();
        CHIONE = new javax.swing.JLabel();
        CRONOS = new javax.swing.JLabel();
        POSEIDON = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        panFin = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        nomGagnant = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Poseidon = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        panOptions = new javax.swing.JPanel();
        panChoix = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comb1j1 = new javax.swing.JLabel();
        comb2j1 = new javax.swing.JLabel();
        comb1j2 = new javax.swing.JLabel();
        comb2j2 = new javax.swing.JLabel();
        comb3j1 = new javax.swing.JLabel();
        comb3j2 = new javax.swing.JLabel();
        vsImage = new javax.swing.JLabel();
        startPanChoix = new javax.swing.JToggleButton();
        panRegles = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        regles1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        panRegles2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        regles10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        panAPropos = new javax.swing.JPanel();
        A_PROPOS = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        panChoixI = new javax.swing.JPanel();
        terre = new javax.swing.JButton();
        feu = new javax.swing.JButton();
        eau = new javax.swing.JButton();
        nature = new javax.swing.JButton();
        foudre = new javax.swing.JButton();
        glace = new javax.swing.JButton();
        foudreTof = new javax.swing.JLabel();
        eauTof = new javax.swing.JLabel();
        combattre = new javax.swing.JButton();
        terreTof = new javax.swing.JLabel();
        feuTof = new javax.swing.JLabel();
        natureTof = new javax.swing.JLabel();
        glaceTof = new javax.swing.JLabel();
        instructionsChoixI1 = new javax.swing.JLabel();
        instructionsChoixI2 = new javax.swing.JLabel();
        instructionsChoixI3 = new javax.swing.JLabel();
        instructionsChoixI4 = new javax.swing.JLabel();
        panGame = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panGameImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        j1 = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        powUp2 = new javax.swing.JToggleButton();
        powUp1 = new javax.swing.JToggleButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        panHome = new javax.swing.JPanel();
        startGame = new javax.swing.JButton();
        qstNbJoueurs = new javax.swing.JLabel();
        nombreJoueurs = new javax.swing.JToggleButton();
        joueur1Name = new javax.swing.JTextField();
        joueur1OK = new javax.swing.JButton();
        joueur2Name = new javax.swing.JTextField();
        joueur2OK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Michael = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        Alex = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jTextField137 = new javax.swing.JTextField();
        jTextField138 = new javax.swing.JTextField();
        jTextField139 = new javax.swing.JTextField();
        jTextField140 = new javax.swing.JTextField();
        jTextField141 = new javax.swing.JTextField();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jTextField142 = new javax.swing.JTextField();
        jTextField143 = new javax.swing.JTextField();
        jLabel179 = new javax.swing.JLabel();
        jTextField144 = new javax.swing.JTextField();
        Vegeta = new javax.swing.JPanel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jTextField145 = new javax.swing.JTextField();
        jTextField146 = new javax.swing.JTextField();
        jTextField147 = new javax.swing.JTextField();
        jTextField148 = new javax.swing.JTextField();
        jTextField149 = new javax.swing.JTextField();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jTextField150 = new javax.swing.JTextField();
        jTextField151 = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        jTextField152 = new javax.swing.JTextField();
        Adam = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jTextField153 = new javax.swing.JTextField();
        jTextField154 = new javax.swing.JTextField();
        jTextField155 = new javax.swing.JTextField();
        jTextField156 = new javax.swing.JTextField();
        jTextField157 = new javax.swing.JTextField();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jTextField158 = new javax.swing.JTextField();
        jTextField159 = new javax.swing.JTextField();
        jLabel197 = new javax.swing.JLabel();
        jTextField160 = new javax.swing.JTextField();
        GAÏA = new javax.swing.JPanel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jTextField161 = new javax.swing.JTextField();
        jTextField162 = new javax.swing.JTextField();
        jTextField163 = new javax.swing.JTextField();
        jTextField164 = new javax.swing.JTextField();
        jTextField165 = new javax.swing.JTextField();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jTextField166 = new javax.swing.JTextField();
        jTextField167 = new javax.swing.JTextField();
        jLabel206 = new javax.swing.JLabel();
        jTextField168 = new javax.swing.JTextField();
        Zeus = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jTextField169 = new javax.swing.JTextField();
        jTextField170 = new javax.swing.JTextField();
        jTextField171 = new javax.swing.JTextField();
        jTextField172 = new javax.swing.JTextField();
        jTextField173 = new javax.swing.JTextField();
        jLabel213 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jTextField174 = new javax.swing.JTextField();
        jTextField175 = new javax.swing.JTextField();
        jLabel215 = new javax.swing.JLabel();
        jTextField176 = new javax.swing.JTextField();
        Kimi = new javax.swing.JPanel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jTextField177 = new javax.swing.JTextField();
        jTextField178 = new javax.swing.JTextField();
        jTextField179 = new javax.swing.JTextField();
        jTextField180 = new javax.swing.JTextField();
        jTextField181 = new javax.swing.JTextField();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jTextField182 = new javax.swing.JTextField();
        jTextField183 = new javax.swing.JTextField();
        jLabel224 = new javax.swing.JLabel();
        jTextField184 = new javax.swing.JTextField();
        Salameche = new javax.swing.JPanel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jTextField185 = new javax.swing.JTextField();
        jTextField186 = new javax.swing.JTextField();
        jTextField187 = new javax.swing.JTextField();
        jTextField188 = new javax.swing.JTextField();
        jTextField189 = new javax.swing.JTextField();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jTextField190 = new javax.swing.JTextField();
        jTextField191 = new javax.swing.JTextField();
        jLabel233 = new javax.swing.JLabel();
        jTextField192 = new javax.swing.JTextField();
        Chronos = new javax.swing.JPanel();
        jLabel234 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jTextField193 = new javax.swing.JTextField();
        jTextField194 = new javax.swing.JTextField();
        jTextField195 = new javax.swing.JTextField();
        jTextField196 = new javax.swing.JTextField();
        jTextField197 = new javax.swing.JTextField();
        jLabel240 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        jTextField198 = new javax.swing.JTextField();
        jTextField199 = new javax.swing.JTextField();
        jLabel242 = new javax.swing.JLabel();
        jTextField200 = new javax.swing.JTextField();
        Toph = new javax.swing.JPanel();
        jLabel243 = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jLabel247 = new javax.swing.JLabel();
        jLabel248 = new javax.swing.JLabel();
        jTextField201 = new javax.swing.JTextField();
        jTextField202 = new javax.swing.JTextField();
        jTextField203 = new javax.swing.JTextField();
        jTextField204 = new javax.swing.JTextField();
        jTextField205 = new javax.swing.JTextField();
        jLabel249 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jTextField206 = new javax.swing.JTextField();
        jTextField207 = new javax.swing.JTextField();
        jLabel251 = new javax.swing.JLabel();
        jTextField208 = new javax.swing.JTextField();
        Carapuce = new javax.swing.JPanel();
        jLabel252 = new javax.swing.JLabel();
        jLabel253 = new javax.swing.JLabel();
        jLabel254 = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        jLabel256 = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        jTextField209 = new javax.swing.JTextField();
        jTextField210 = new javax.swing.JTextField();
        jTextField211 = new javax.swing.JTextField();
        jTextField212 = new javax.swing.JTextField();
        jTextField213 = new javax.swing.JTextField();
        jLabel258 = new javax.swing.JLabel();
        jLabel259 = new javax.swing.JLabel();
        jTextField214 = new javax.swing.JTextField();
        jTextField215 = new javax.swing.JTextField();
        jLabel260 = new javax.swing.JLabel();
        jTextField216 = new javax.swing.JTextField();
        Pikachu = new javax.swing.JPanel();
        jLabel261 = new javax.swing.JLabel();
        jLabel262 = new javax.swing.JLabel();
        jLabel263 = new javax.swing.JLabel();
        jLabel264 = new javax.swing.JLabel();
        jLabel265 = new javax.swing.JLabel();
        jLabel266 = new javax.swing.JLabel();
        jTextField217 = new javax.swing.JTextField();
        jTextField218 = new javax.swing.JTextField();
        jTextField219 = new javax.swing.JTextField();
        jTextField220 = new javax.swing.JTextField();
        jTextField221 = new javax.swing.JTextField();
        jLabel267 = new javax.swing.JLabel();
        jLabel268 = new javax.swing.JLabel();
        jTextField222 = new javax.swing.JTextField();
        jTextField223 = new javax.swing.JTextField();
        jLabel269 = new javax.swing.JLabel();
        jTextField224 = new javax.swing.JTextField();
        Quentin = new javax.swing.JPanel();
        jLabel270 = new javax.swing.JLabel();
        jLabel271 = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jLabel275 = new javax.swing.JLabel();
        jTextField225 = new javax.swing.JTextField();
        jTextField226 = new javax.swing.JTextField();
        jTextField227 = new javax.swing.JTextField();
        jTextField228 = new javax.swing.JTextField();
        jTextField229 = new javax.swing.JTextField();
        jLabel276 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jTextField230 = new javax.swing.JTextField();
        jTextField231 = new javax.swing.JTextField();
        jLabel278 = new javax.swing.JLabel();
        jTextField232 = new javax.swing.JTextField();
        Mbappe = new javax.swing.JPanel();
        jLabel279 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        jLabel282 = new javax.swing.JLabel();
        jLabel283 = new javax.swing.JLabel();
        jLabel284 = new javax.swing.JLabel();
        jTextField233 = new javax.swing.JTextField();
        jTextField234 = new javax.swing.JTextField();
        jTextField235 = new javax.swing.JTextField();
        jTextField236 = new javax.swing.JTextField();
        jTextField237 = new javax.swing.JTextField();
        jLabel285 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jTextField238 = new javax.swing.JTextField();
        jTextField239 = new javax.swing.JTextField();
        jLabel287 = new javax.swing.JLabel();
        jTextField240 = new javax.swing.JTextField();
        Pesquet = new javax.swing.JPanel();
        jLabel288 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        jLabel290 = new javax.swing.JLabel();
        jLabel291 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jTextField241 = new javax.swing.JTextField();
        jTextField242 = new javax.swing.JTextField();
        jTextField243 = new javax.swing.JTextField();
        jTextField244 = new javax.swing.JTextField();
        jTextField245 = new javax.swing.JTextField();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        jTextField246 = new javax.swing.JTextField();
        jTextField247 = new javax.swing.JTextField();
        jLabel296 = new javax.swing.JLabel();
        jTextField248 = new javax.swing.JTextField();
        Hades = new javax.swing.JPanel();
        jLabel297 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        jTextField249 = new javax.swing.JTextField();
        jTextField250 = new javax.swing.JTextField();
        jTextField251 = new javax.swing.JTextField();
        jTextField252 = new javax.swing.JTextField();
        jTextField253 = new javax.swing.JTextField();
        jLabel303 = new javax.swing.JLabel();
        jLabel304 = new javax.swing.JLabel();
        jTextField254 = new javax.swing.JTextField();
        jTextField255 = new javax.swing.JTextField();
        jLabel305 = new javax.swing.JLabel();
        jTextField256 = new javax.swing.JTextField();
        Acteon = new javax.swing.JPanel();
        jLabel306 = new javax.swing.JLabel();
        jLabel307 = new javax.swing.JLabel();
        jLabel308 = new javax.swing.JLabel();
        jLabel309 = new javax.swing.JLabel();
        jLabel310 = new javax.swing.JLabel();
        jLabel311 = new javax.swing.JLabel();
        jTextField257 = new javax.swing.JTextField();
        jTextField258 = new javax.swing.JTextField();
        jTextField259 = new javax.swing.JTextField();
        jTextField260 = new javax.swing.JTextField();
        jTextField261 = new javax.swing.JTextField();
        jLabel312 = new javax.swing.JLabel();
        jLabel313 = new javax.swing.JLabel();
        jTextField262 = new javax.swing.JTextField();
        jTextField263 = new javax.swing.JTextField();
        jLabel314 = new javax.swing.JLabel();
        jTextField264 = new javax.swing.JTextField();
        Chione = new javax.swing.JPanel();
        jLabel315 = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        jLabel317 = new javax.swing.JLabel();
        jLabel318 = new javax.swing.JLabel();
        jLabel319 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        jTextField265 = new javax.swing.JTextField();
        jTextField266 = new javax.swing.JTextField();
        jTextField267 = new javax.swing.JTextField();
        jTextField268 = new javax.swing.JTextField();
        jTextField269 = new javax.swing.JTextField();
        jLabel321 = new javax.swing.JLabel();
        jLabel322 = new javax.swing.JLabel();
        jTextField270 = new javax.swing.JTextField();
        jTextField271 = new javax.swing.JTextField();
        jLabel323 = new javax.swing.JLabel();
        jTextField272 = new javax.swing.JTextField();
        barreDeMenu = new javax.swing.JMenuBar();
        menuGame = new javax.swing.JMenu();
        menuSettings = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();

        jLabel8.setText("jLabel8");

        jLabel29.setText("jLabel29");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Le clash des Empereurs");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(65, 105, 225));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);

        Panel1.setBackground(new java.awt.Color(255, 153, 153));
        Panel1.setPreferredSize(new java.awt.Dimension(200, 341));

        jp1.setBackground(new java.awt.Color(255, 204, 204));
        jp1.setMaximumSize(new java.awt.Dimension(194, 40));
        jp1.setMinimumSize(new java.awt.Dimension(194, 40));
        jp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp1MouseClicked(evt);
            }
        });

        persoLabel.setText("HOME");

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(persoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(persoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp3.setBackground(new java.awt.Color(255, 204, 204));
        jp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp3MouseClicked(evt);
            }
        });

        persoLabel1.setText("Règles du jeu");

        javax.swing.GroupLayout jp3Layout = new javax.swing.GroupLayout(jp3);
        jp3.setLayout(jp3Layout);
        jp3Layout.setHorizontalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(persoLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp3Layout.setVerticalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(persoLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp2.setBackground(new java.awt.Color(255, 204, 204));
        jp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp2MouseClicked(evt);
            }
        });

        persoLabel2.setText("Personnages");

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(persoLabel2)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(persoLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp4.setBackground(new java.awt.Color(255, 204, 204));
        jp4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp4MouseClicked(evt);
            }
        });

        persoLabel3.setText("A propos");

        javax.swing.GroupLayout jp4Layout = new javax.swing.GroupLayout(jp4);
        jp4.setLayout(jp4Layout);
        jp4Layout.setHorizontalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp4Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(persoLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp4Layout.setVerticalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(persoLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logo.setText(" ");

        insa.setText(" ");

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(insa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        panPersos.setBackground(new java.awt.Color(0, 102, 255));
        panPersos.setPreferredSize(new java.awt.Dimension(511, 487));

        TOPH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TOPH.setText("Toph");
        TOPH.setFocusable(false);
        TOPH.setMaximumSize(new java.awt.Dimension(75, 14));
        TOPH.setPreferredSize(new java.awt.Dimension(75, 75));
        TOPH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TOPHMouseClicked(evt);
            }
        });

        KIMI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KIMI.setText("Kimi Raikkonen");
        KIMI.setMaximumSize(new java.awt.Dimension(75, 14));
        KIMI.setPreferredSize(new java.awt.Dimension(75, 75));
        KIMI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KIMIMouseClicked(evt);
            }
        });

        CARAPUCE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CARAPUCE.setText("Carapuce");
        CARAPUCE.setMaximumSize(new java.awt.Dimension(75, 14));
        CARAPUCE.setPreferredSize(new java.awt.Dimension(75, 75));
        CARAPUCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CARAPUCEMouseClicked(evt);
            }
        });

        SALAMECHE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SALAMECHE.setText("Salamèche");
        SALAMECHE.setMaximumSize(new java.awt.Dimension(75, 14));
        SALAMECHE.setPreferredSize(new java.awt.Dimension(75, 75));
        SALAMECHE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SALAMECHEMouseClicked(evt);
            }
        });

        VEGETA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VEGETA.setText("Vegeta");
        VEGETA.setMaximumSize(new java.awt.Dimension(75, 14));
        VEGETA.setPreferredSize(new java.awt.Dimension(75, 75));
        VEGETA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VEGETAMouseClicked(evt);
            }
        });

        PIKACHU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PIKACHU.setText("Pikachu");
        PIKACHU.setMaximumSize(new java.awt.Dimension(75, 14));
        PIKACHU.setPreferredSize(new java.awt.Dimension(75, 75));
        PIKACHU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PIKACHUMouseClicked(evt);
            }
        });

        MARCHALOT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MARCHALOT.setText("Mr. Marchalot");
        MARCHALOT.setMaximumSize(new java.awt.Dimension(75, 14));
        MARCHALOT.setPreferredSize(new java.awt.Dimension(75, 75));

        ALEXANDRE_LE_GRAND.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ALEXANDRE_LE_GRAND.setText("Alexandre");
        ALEXANDRE_LE_GRAND.setMaximumSize(new java.awt.Dimension(75, 14));
        ALEXANDRE_LE_GRAND.setPreferredSize(new java.awt.Dimension(75, 75));
        ALEXANDRE_LE_GRAND.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ALEXANDRE_LE_GRANDMouseClicked(evt);
            }
        });

        QUENTIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QUENTIN.setText("Quentin");
        QUENTIN.setMaximumSize(new java.awt.Dimension(75, 14));
        QUENTIN.setPreferredSize(new java.awt.Dimension(75, 75));
        QUENTIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QUENTINMouseClicked(evt);
            }
        });

        ADAM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ADAM.setText("Adam");
        ADAM.setMaximumSize(new java.awt.Dimension(75, 14));
        ADAM.setPreferredSize(new java.awt.Dimension(75, 75));
        ADAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADAMMouseClicked(evt);
            }
        });

        MBAPPE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MBAPPE.setText("Mbappe");
        MBAPPE.setMaximumSize(new java.awt.Dimension(75, 14));
        MBAPPE.setPreferredSize(new java.awt.Dimension(75, 75));
        MBAPPE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MBAPPEMouseClicked(evt);
            }
        });

        MICHAEL_JACKSON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MICHAEL_JACKSON.setText("Michael ");
        MICHAEL_JACKSON.setMaximumSize(new java.awt.Dimension(75, 14));
        MICHAEL_JACKSON.setPreferredSize(new java.awt.Dimension(75, 75));
        MICHAEL_JACKSON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MICHAEL_JACKSONMouseClicked(evt);
            }
        });

        THOMAS_PESQUET.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        THOMAS_PESQUET.setText("Thomas Pesquet");
        THOMAS_PESQUET.setMaximumSize(new java.awt.Dimension(75, 14));
        THOMAS_PESQUET.setPreferredSize(new java.awt.Dimension(75, 75));
        THOMAS_PESQUET.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                THOMAS_PESQUETMouseClicked(evt);
            }
        });

        GAIA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GAIA.setText("Gaïa");
        GAIA.setMaximumSize(new java.awt.Dimension(75, 14));
        GAIA.setPreferredSize(new java.awt.Dimension(75, 75));
        GAIA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GAIAMouseClicked(evt);
            }
        });

        HADES.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HADES.setText("Hades");
        HADES.setMaximumSize(new java.awt.Dimension(75, 14));
        HADES.setPreferredSize(new java.awt.Dimension(75, 75));
        HADES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HADESMouseClicked(evt);
            }
        });

        ACTEON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ACTEON.setText("Actéon");
        ACTEON.setMaximumSize(new java.awt.Dimension(75, 14));
        ACTEON.setPreferredSize(new java.awt.Dimension(75, 75));
        ACTEON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ACTEONMouseClicked(evt);
            }
        });

        ZEUS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ZEUS.setText("Zeus");
        ZEUS.setMaximumSize(new java.awt.Dimension(75, 14));
        ZEUS.setPreferredSize(new java.awt.Dimension(75, 75));
        ZEUS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ZEUSMouseClicked(evt);
            }
        });

        CHIONE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CHIONE.setText("Chioné");
        CHIONE.setMaximumSize(new java.awt.Dimension(75, 14));
        CHIONE.setPreferredSize(new java.awt.Dimension(75, 75));
        CHIONE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CHIONEMouseClicked(evt);
            }
        });

        CRONOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CRONOS.setText("Chronos");
        CRONOS.setMaximumSize(new java.awt.Dimension(75, 14));
        CRONOS.setPreferredSize(new java.awt.Dimension(75, 75));
        CRONOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CRONOSMouseClicked(evt);
            }
        });

        POSEIDON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        POSEIDON.setText("Poséidon");
        POSEIDON.setMaximumSize(new java.awt.Dimension(75, 14));
        POSEIDON.setPreferredSize(new java.awt.Dimension(75, 75));
        POSEIDON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                POSEIDONMouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Personnages");

        javax.swing.GroupLayout panPersosLayout = new javax.swing.GroupLayout(panPersos);
        panPersos.setLayout(panPersosLayout);
        panPersosLayout.setHorizontalGroup(
            panPersosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPersosLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(panPersosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panPersosLayout.createSequentialGroup()
                        .addComponent(KIMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MARCHALOT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ALEXANDRE_LE_GRAND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QUENTIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ADAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panPersosLayout.createSequentialGroup()
                        .addGroup(panPersosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panPersosLayout.createSequentialGroup()
                                .addComponent(POSEIDON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ACTEON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panPersosLayout.createSequentialGroup()
                                .addComponent(MBAPPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MICHAEL_JACKSON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panPersosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panPersosLayout.createSequentialGroup()
                                .addComponent(THOMAS_PESQUET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GAIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HADES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panPersosLayout.createSequentialGroup()
                                .addComponent(ZEUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CHIONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CRONOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panPersosLayout.createSequentialGroup()
                        .addComponent(TOPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SALAMECHE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CARAPUCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VEGETA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PIKACHU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panPersosLayout.setVerticalGroup(
            panPersosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPersosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addGroup(panPersosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TOPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SALAMECHE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CARAPUCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VEGETA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PIKACHU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panPersosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KIMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MARCHALOT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ALEXANDRE_LE_GRAND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QUENTIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panPersosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MBAPPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MICHAEL_JACKSON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(THOMAS_PESQUET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GAIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HADES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panPersosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ACTEON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZEUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CHIONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CRONOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(POSEIDON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        panFin.setBackground(java.awt.Color.green);

        jLabel9.setFont(new java.awt.Font("Segoe Script", 3, 28)); // NOI18N
        jLabel9.setForeground(java.awt.Color.magenta);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("FELICITATIONS !!!!");

        nomGagnant.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 34)); // NOI18N
        nomGagnant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomGagnant.setText("Nom gagnant");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("On espère que ça vous a plu ");

        javax.swing.GroupLayout panFinLayout = new javax.swing.GroupLayout(panFin);
        panFin.setLayout(panFinLayout);
        panFinLayout.setHorizontalGroup(
            panFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFinLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(panFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nomGagnant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        panFinLayout.setVerticalGroup(
            panFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFinLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel9)
                .addGap(77, 77, 77)
                .addComponent(nomGagnant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(103, 103, 103))
        );

        Poseidon.setBackground(java.awt.Color.blue);

        jLabel15.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(122, 122, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("POSEIDON");

        jLabel16.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel16.setText("Element");

        jLabel17.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel17.setText("Vie");

        jLabel18.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel18.setText("Attaque 1");

        jLabel19.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel19.setText("Attaque 2");

        jLabel20.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel20.setText("Attaque 3");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Eau");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("2775");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("277.5");

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("510");

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("720");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel21.setText("Attaque S");

        jLabel22.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel22.setText("Soin");

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("1425");

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("600");

        jLabel23.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel23.setText("Vitesse");

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("8");

        javax.swing.GroupLayout PoseidonLayout = new javax.swing.GroupLayout(Poseidon);
        Poseidon.setLayout(PoseidonLayout);
        PoseidonLayout.setHorizontalGroup(
            PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PoseidonLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PoseidonLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PoseidonLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PoseidonLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PoseidonLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PoseidonLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PoseidonLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PoseidonLayout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1))
                        .addGroup(PoseidonLayout.createSequentialGroup()
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        PoseidonLayout.setVerticalGroup(
            PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PoseidonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PoseidonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panOptions.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout panOptionsLayout = new javax.swing.GroupLayout(panOptions);
        panOptions.setLayout(panOptionsLayout);
        panOptionsLayout.setHorizontalGroup(
            panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panOptionsLayout.setVerticalGroup(
            panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        panChoix.setBackground(java.awt.Color.orange);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.blue);
        jLabel6.setText("Choisissez votre combattant");

        comb1j1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comb1j1.setText("comb1j1");
        comb1j1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comb1j1MouseClicked(evt);
            }
        });

        comb2j1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comb2j1.setText("comb2j1");
        comb2j1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comb2j1MouseClicked(evt);
            }
        });

        comb1j2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comb1j2.setText("comb1j2");
        comb1j2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comb1j2MouseClicked(evt);
            }
        });

        comb2j2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comb2j2.setText("comb2j2");
        comb2j2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comb2j2MouseClicked(evt);
            }
        });

        comb3j1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comb3j1.setText("comb3j1");
        comb3j1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comb3j1MouseClicked(evt);
            }
        });

        comb3j2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comb3j2.setText("comb3j2");
        comb3j2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comb3j2MouseClicked(evt);
            }
        });

        vsImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vsImage.setText("VS");

        startPanChoix.setText("START");
        startPanChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPanChoixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panChoixLayout = new javax.swing.GroupLayout(panChoix);
        panChoix.setLayout(panChoixLayout);
        panChoixLayout.setHorizontalGroup(
            panChoixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChoixLayout.createSequentialGroup()
                .addGroup(panChoixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panChoixLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comb3j2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panChoixLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(panChoixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panChoixLayout.createSequentialGroup()
                                .addComponent(comb3j1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panChoixLayout.createSequentialGroup()
                                .addComponent(comb1j1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comb1j2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panChoixLayout.createSequentialGroup()
                                .addComponent(comb2j1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(vsImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(comb2j2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChoixLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panChoixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChoixLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChoixLayout.createSequentialGroup()
                        .addComponent(startPanChoix)
                        .addGap(212, 212, 212))))
        );
        panChoixLayout.setVerticalGroup(
            panChoixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChoixLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(panChoixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comb1j1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb1j2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panChoixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comb2j1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb2j2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vsImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panChoixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comb3j1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb3j2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startPanChoix)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        panRegles.setBackground(java.awt.Color.pink);
        panRegles.setForeground(java.awt.Color.darkGray);

        jLabel11.setFont(new java.awt.Font("Chiller", 3, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("REGLES DU JEU");

        regles1.setText("jLabel13");

        jButton4.setText("Continuer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panReglesLayout = new javax.swing.GroupLayout(panRegles);
        panRegles.setLayout(panReglesLayout);
        panReglesLayout.setHorizontalGroup(
            panReglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panReglesLayout.createSequentialGroup()
                .addGroup(panReglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panReglesLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panReglesLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(regles1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panReglesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(55, 55, 55))
        );
        panReglesLayout.setVerticalGroup(
            panReglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panReglesLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel11)
                .addGap(29, 29, 29)
                .addComponent(regles1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        panRegles2.setBackground(java.awt.Color.pink);

        jLabel14.setFont(new java.awt.Font("Chiller", 3, 36)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("REGLES DU JEU");

        regles10.setText("jLabel29");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Charger", "Attaque 1", "Attaque 2", "Attaque 3", "Attaque S", "Soin", "Switch", "Activer domaine" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel30.setText(" ");

        jButton3.setText("Continuer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRegles2Layout = new javax.swing.GroupLayout(panRegles2);
        panRegles2.setLayout(panRegles2Layout);
        panRegles2Layout.setHorizontalGroup(
            panRegles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegles2Layout.createSequentialGroup()
                .addGroup(panRegles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRegles2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panRegles2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(regles10, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panRegles2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegles2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panRegles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegles2Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegles2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(59, 59, 59))))
        );
        panRegles2Layout.setVerticalGroup(
            panRegles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegles2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel14)
                .addGap(27, 27, 27)
                .addComponent(regles10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        panAPropos.setBackground(new java.awt.Color(255, 255, 153));

        A_PROPOS.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A PROPOS");

        jButton1.setText("QUENTIN ROSSI");

        jButton2.setText("ADAM LAALOUJ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("ALEXANDRE LOUSTRIC");

        javax.swing.GroupLayout panAProposLayout = new javax.swing.GroupLayout(panAPropos);
        panAPropos.setLayout(panAProposLayout);
        panAProposLayout.setHorizontalGroup(
            panAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAProposLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(A_PROPOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
                    .addGroup(panAProposLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panAProposLayout.setVerticalGroup(
            panAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAProposLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(A_PROPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        panChoixI.setBackground(java.awt.Color.red);

        terre.setText("Toph");
        terre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terreActionPerformed(evt);
            }
        });

        feu.setText("Salamèche");
        feu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feuActionPerformed(evt);
            }
        });

        eau.setText("Carapuce");
        eau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eauActionPerformed(evt);
            }
        });

        nature.setText("Vegeta");
        nature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                natureActionPerformed(evt);
            }
        });

        foudre.setText("Pikachu");
        foudre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foudreActionPerformed(evt);
            }
        });

        glace.setText("Kimi");
        glace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glaceActionPerformed(evt);
            }
        });

        foudreTof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foudreTof.setText("Pikachu");

        eauTof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eauTof.setText("Carapuce");

        combattre.setText("Continuer");
        combattre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combattreActionPerformed(evt);
            }
        });

        terreTof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        terreTof.setText("Toph Photo");

        feuTof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        feuTof.setText("Salamèche");

        natureTof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        natureTof.setText("Vegeta");

        glaceTof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        glaceTof.setText("Kimi");

        instructionsChoixI1.setText("Bonjour,");

        instructionsChoixI2.setText("Ici, vous aurez à choisir deux de ");

        instructionsChoixI3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        instructionsChoixI3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructionsChoixI3.setText("à vous de jouer");

        instructionsChoixI4.setText("vos trois combattants");

        javax.swing.GroupLayout panChoixILayout = new javax.swing.GroupLayout(panChoixI);
        panChoixI.setLayout(panChoixILayout);
        panChoixILayout.setHorizontalGroup(
            panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChoixILayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(foudreTof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eauTof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(terreTof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(terre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(foudre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(instructionsChoixI1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(instructionsChoixI2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(instructionsChoixI3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(instructionsChoixI4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(feu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(glace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feuTof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(natureTof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(glaceTof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71))
            .addGroup(panChoixILayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(combattre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panChoixILayout.setVerticalGroup(
            panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChoixILayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(feuTof, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(terreTof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(terre)
                    .addComponent(feu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panChoixILayout.createSequentialGroup()
                        .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(natureTof, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(eauTof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eau)
                            .addComponent(nature)))
                    .addGroup(panChoixILayout.createSequentialGroup()
                        .addComponent(instructionsChoixI1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(instructionsChoixI2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(foudreTof, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addComponent(glaceTof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panChoixILayout.createSequentialGroup()
                        .addComponent(instructionsChoixI4)
                        .addGap(18, 18, 18)
                        .addComponent(instructionsChoixI3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panChoixILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(foudre)
                    .addComponent(glace))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(combattre)
                .addGap(33, 33, 33))
        );

        panGame.setBackground(new java.awt.Color(0, 102, 51));

        jLabel5.setText("Ici, apparaîtront les actions du joueur 2");

        panGameImage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panGameImageKeyPressed(evt);
            }
        });

        jLabel4.setText("Ici, apparaîtront les actions du joueur 1");

        j1.setText(" ");

        j2.setText(" ");

        jProgressBar1.setStringPainted(true);

        jProgressBar2.setStringPainted(true);

        powUp2.setText("Activer domaine");
        powUp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powUp2ActionPerformed(evt);
            }
        });

        powUp1.setText("Activer domaine");
        powUp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powUp1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Charger", "Attaque 1", "Attaque 2", "Attaque 3", "Attaque S", "Soin", "Switch" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Charger", "Attaque 1", "Attaque 2", "Attaque 3", "Attaque S", "Soin", "Switch" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jProgressBar3.setStringPainted(true);

        jProgressBar4.setStringPainted(true);

        javax.swing.GroupLayout panGameLayout = new javax.swing.GroupLayout(panGame);
        panGame.setLayout(panGameLayout);
        panGameLayout.setHorizontalGroup(
            panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGameLayout.createSequentialGroup()
                .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panGameLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(panGameLayout.createSequentialGroup()
                                .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(149, 149, 149)
                                .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProgressBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panGameLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(powUp1)
                            .addGroup(panGameLayout.createSequentialGroup()
                                .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panGameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panGameLayout.createSequentialGroup()
                        .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panGameLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panGameLayout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panGameLayout.createSequentialGroup()
                        .addComponent(powUp2)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panGameLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panGameImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
        );
        panGameLayout.setVerticalGroup(
            panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panGameLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(powUp2)
                    .addComponent(powUp1))
                .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panGameLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panGameLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addGap(16, 16, 16))
            .addGroup(panGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panGameLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panGameImage, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panHome.setBackground(new java.awt.Color(255, 255, 0));

        startGame.setText("START GAME");
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });

        qstNbJoueurs.setText("Bonjour, Voulez-vous jouer à 1 ou à 2 joueurs ?");

        nombreJoueurs.setText("1");
        nombreJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreJoueursActionPerformed(evt);
            }
        });

        joueur1Name.setText("Joueur 1");
        joueur1Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                joueur1NameMouseClicked(evt);
            }
        });
        joueur1Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joueur1NameActionPerformed(evt);
            }
        });

        joueur1OK.setText("OK");
        joueur1OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joueur1OKActionPerformed(evt);
            }
        });

        joueur2Name.setText("Joueur 2");
        joueur2Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                joueur2NameMouseClicked(evt);
            }
        });
        joueur2Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joueur2NameActionPerformed(evt);
            }
        });

        joueur2OK.setText("OK");
        joueur2OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joueur2OKActionPerformed(evt);
            }
        });

        jLabel2.setText("Comment vous appelez-vous?");

        jLabel3.setText("Comment vous appelez-vous?");

        javax.swing.GroupLayout panHomeLayout = new javax.swing.GroupLayout(panHome);
        panHome.setLayout(panHomeLayout);
        panHomeLayout.setHorizontalGroup(
            panHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHomeLayout.createSequentialGroup()
                .addGroup(panHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panHomeLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(joueur1OK))
                    .addGroup(panHomeLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(joueur2OK)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panHomeLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panHomeLayout.createSequentialGroup()
                        .addGroup(panHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joueur2Name)
                            .addComponent(joueur1Name)
                            .addGroup(panHomeLayout.createSequentialGroup()
                                .addComponent(qstNbJoueurs, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(nombreJoueurs, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55))
                    .addGroup(panHomeLayout.createSequentialGroup()
                        .addGroup(panHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panHomeLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(startGame)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panHomeLayout.setVerticalGroup(
            panHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panHomeLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qstNbJoueurs, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreJoueurs))
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joueur1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(joueur1OK)
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joueur2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(joueur2OK)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(startGame)
                .addGap(48, 48, 48))
        );

        Michael.setBackground(java.awt.Color.darkGray);

        jLabel24.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel24.setForeground(java.awt.Color.yellow);
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("MICHAEL JACKSON");

        jLabel26.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel26.setText("Element");

        jLabel27.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel27.setText("Vie");

        jLabel28.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel28.setText("Attaque 1");

        jLabel31.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel31.setText("Attaque 2");

        jLabel32.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel32.setText("Attaque 3");

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("king of pop");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("3000");

        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("300");

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("300");

        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText("1075");
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel33.setText("Attaque S");

        jLabel34.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel34.setText("Soin");

        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("2200");

        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("500");

        jLabel35.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel35.setText("Vitesse");

        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setText("9");
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MichaelLayout = new javax.swing.GroupLayout(Michael);
        Michael.setLayout(MichaelLayout);
        MichaelLayout.setHorizontalGroup(
            MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MichaelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MichaelLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MichaelLayout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MichaelLayout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MichaelLayout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MichaelLayout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MichaelLayout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MichaelLayout.createSequentialGroup()
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField9))
                        .addGroup(MichaelLayout.createSequentialGroup()
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        MichaelLayout.setVerticalGroup(
            MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MichaelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MichaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Alex.setBackground(java.awt.Color.red);

        jLabel171.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel171.setText("ALEXANDRE");

        jLabel172.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel172.setText("Element");

        jLabel173.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel173.setText("Vie");

        jLabel174.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel174.setText("Attaque 1");

        jLabel175.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel175.setText("Attaque 2");

        jLabel176.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel176.setText("Attaque 3");

        jTextField137.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField137.setText("Bogoss");
        jTextField137.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField137ActionPerformed(evt);
            }
        });

        jTextField138.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField138.setText("2800");

        jTextField139.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField139.setText("300");

        jTextField140.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField140.setText("300");

        jTextField141.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField141.setText("1175");
        jTextField141.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField141ActionPerformed(evt);
            }
        });

        jLabel177.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel177.setText("Attaque S");

        jLabel178.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel178.setText("Soin");

        jTextField142.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField142.setText("2300");

        jTextField143.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField143.setText("500");

        jLabel179.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel179.setText("Vitesse");

        jTextField144.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField144.setText("8");

        javax.swing.GroupLayout AlexLayout = new javax.swing.GroupLayout(Alex);
        Alex.setLayout(AlexLayout);
        AlexLayout.setHorizontalGroup(
            AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlexLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AlexLayout.createSequentialGroup()
                        .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField139, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AlexLayout.createSequentialGroup()
                        .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField140, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AlexLayout.createSequentialGroup()
                        .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField141, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AlexLayout.createSequentialGroup()
                        .addComponent(jLabel177, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField142, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AlexLayout.createSequentialGroup()
                        .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField143, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AlexLayout.createSequentialGroup()
                        .addComponent(jLabel179, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField144, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AlexLayout.createSequentialGroup()
                            .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField137))
                        .addGroup(AlexLayout.createSequentialGroup()
                            .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField138, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        AlexLayout.setVerticalGroup(
            AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField137, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField138, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField139, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField140, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField141, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel177, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField142, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AlexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel179, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Vegeta.setBackground(java.awt.Color.green);

        jLabel180.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(0, 134, 0));
        jLabel180.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel180.setText("VEGETA");

        jLabel181.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel181.setText("Element");

        jLabel182.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel182.setText("Vie");

        jLabel183.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel183.setText("Attaque 1");

        jLabel184.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel184.setText("Attaque 2");

        jLabel185.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel185.setText("Attaque 3");

        jTextField145.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField145.setText("Nature");
        jTextField145.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField145ActionPerformed(evt);
            }
        });

        jTextField146.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField146.setText("1900");

        jTextField147.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField147.setText("190");

        jTextField148.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField148.setText("350");

        jTextField149.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField149.setText("445");
        jTextField149.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField149ActionPerformed(evt);
            }
        });

        jLabel186.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel186.setText("Attaque S");

        jLabel187.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel187.setText("Soin");

        jTextField150.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField150.setText("925");

        jTextField151.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField151.setText("475");

        jLabel188.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel188.setText("Vitesse");

        jTextField152.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField152.setText("7");

        javax.swing.GroupLayout VegetaLayout = new javax.swing.GroupLayout(Vegeta);
        Vegeta.setLayout(VegetaLayout);
        VegetaLayout.setHorizontalGroup(
            VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VegetaLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VegetaLayout.createSequentialGroup()
                        .addComponent(jLabel183, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField147, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VegetaLayout.createSequentialGroup()
                        .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField148, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VegetaLayout.createSequentialGroup()
                        .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField149, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VegetaLayout.createSequentialGroup()
                        .addComponent(jLabel186, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField150, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VegetaLayout.createSequentialGroup()
                        .addComponent(jLabel187, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField151, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VegetaLayout.createSequentialGroup()
                        .addComponent(jLabel188, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField152, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, VegetaLayout.createSequentialGroup()
                            .addComponent(jLabel181, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField145))
                        .addGroup(VegetaLayout.createSequentialGroup()
                            .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField146, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        VegetaLayout.setVerticalGroup(
            VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VegetaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel181, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField146, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel183, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField147, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField148, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField149, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel186, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField150, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel187, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField151, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(VegetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel188, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField152, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Adam.setBackground(java.awt.Color.orange);

        jLabel189.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(77, 77, 255));
        jLabel189.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel189.setText("ADAM");

        jLabel190.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel190.setText("Element");

        jLabel191.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel191.setText("Vie");

        jLabel192.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel192.setText("Attaque 1");

        jLabel193.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel193.setText("Attaque 2");

        jLabel194.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel194.setText("Attaque 3");

        jTextField153.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField153.setText(" ");
        jTextField153.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField153ActionPerformed(evt);
            }
        });

        jTextField154.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField154.setText("2750");

        jTextField155.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField155.setText("300");

        jTextField156.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField156.setText("300");

        jTextField157.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField157.setText("1275");
        jTextField157.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField157ActionPerformed(evt);
            }
        });

        jLabel195.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel195.setText("Attaque S");

        jLabel196.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel196.setText("Soin");

        jTextField158.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField158.setText("2400");

        jTextField159.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField159.setText("500");

        jLabel197.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel197.setText("Vitesse");

        jTextField160.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField160.setText("7");

        javax.swing.GroupLayout AdamLayout = new javax.swing.GroupLayout(Adam);
        Adam.setLayout(AdamLayout);
        AdamLayout.setHorizontalGroup(
            AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdamLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdamLayout.createSequentialGroup()
                        .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField155, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdamLayout.createSequentialGroup()
                        .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField156, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdamLayout.createSequentialGroup()
                        .addComponent(jLabel194, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField157, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdamLayout.createSequentialGroup()
                        .addComponent(jLabel195, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField158, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdamLayout.createSequentialGroup()
                        .addComponent(jLabel196, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField159, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdamLayout.createSequentialGroup()
                        .addComponent(jLabel197, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField160, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AdamLayout.createSequentialGroup()
                            .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField153))
                        .addGroup(AdamLayout.createSequentialGroup()
                            .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField154, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        AdamLayout.setVerticalGroup(
            AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField153, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField154, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField155, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField156, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel194, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField157, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel195, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField158, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel196, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField159, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AdamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel197, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        GAÏA.setBackground(java.awt.Color.green);

        jLabel198.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(0, 155, 0));
        jLabel198.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel198.setText("GAÏA");

        jLabel199.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel199.setText("Element");

        jLabel200.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel200.setText("Vie");

        jLabel201.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel201.setText("Attaque 1");

        jLabel202.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel202.setText("Attaque 2");

        jLabel203.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel203.setText("Attaque 3");

        jTextField161.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField161.setText("Terre");
        jTextField161.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField161ActionPerformed(evt);
            }
        });

        jTextField162.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField162.setText("3750");

        jTextField163.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField163.setText("375");

        jTextField164.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField164.setText("525");

        jTextField165.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField165.setText("600");
        jTextField165.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField165ActionPerformed(evt);
            }
        });

        jLabel204.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel204.setText("Attaque S");

        jLabel205.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel205.setText("Soin");

        jTextField166.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField166.setText("1200");

        jTextField167.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField167.setText("450");

        jLabel206.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel206.setText("Vitesse");

        jTextField168.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField168.setText("4");

        javax.swing.GroupLayout GAÏALayout = new javax.swing.GroupLayout(GAÏA);
        GAÏA.setLayout(GAÏALayout);
        GAÏALayout.setHorizontalGroup(
            GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GAÏALayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel198, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GAÏALayout.createSequentialGroup()
                        .addComponent(jLabel201, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField163, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GAÏALayout.createSequentialGroup()
                        .addComponent(jLabel202, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField164, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GAÏALayout.createSequentialGroup()
                        .addComponent(jLabel203, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField165, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GAÏALayout.createSequentialGroup()
                        .addComponent(jLabel204, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField166, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GAÏALayout.createSequentialGroup()
                        .addComponent(jLabel205, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField167, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GAÏALayout.createSequentialGroup()
                        .addComponent(jLabel206, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField168, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GAÏALayout.createSequentialGroup()
                            .addComponent(jLabel199, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField161))
                        .addGroup(GAÏALayout.createSequentialGroup()
                            .addComponent(jLabel200, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField162, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        GAÏALayout.setVerticalGroup(
            GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GAÏALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel198, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel199, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField161, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel200, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField162, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel201, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField163, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel202, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField164, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel203, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField165, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel204, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField166, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel205, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField167, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(GAÏALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel206, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField168, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Zeus.setBackground(java.awt.Color.blue);

        jLabel207.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(205, 230, 0));
        jLabel207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel207.setText("ZEUS");

        jLabel208.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel208.setText("Element");

        jLabel209.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel209.setText("Vie");

        jLabel210.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel210.setText("Attaque 1");

        jLabel211.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel211.setText("Attaque 2");

        jLabel212.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel212.setText("Attaque 3");

        jTextField169.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField169.setText("Eau");
        jTextField169.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField169ActionPerformed(evt);
            }
        });

        jTextField170.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField170.setText("2500");

        jTextField171.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField171.setText("75");

        jTextField172.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField172.setText("200");

        jTextField173.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField173.setText("1000");
        jTextField173.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField173ActionPerformed(evt);
            }
        });

        jLabel213.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel213.setText("Attaque S");

        jLabel214.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel214.setText("Soin");

        jTextField174.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField174.setText("1600");

        jTextField175.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField175.setText("500");

        jLabel215.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel215.setText("Vitesse");

        jTextField176.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField176.setText("7");

        javax.swing.GroupLayout ZeusLayout = new javax.swing.GroupLayout(Zeus);
        Zeus.setLayout(ZeusLayout);
        ZeusLayout.setHorizontalGroup(
            ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZeusLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel207, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ZeusLayout.createSequentialGroup()
                        .addComponent(jLabel210, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField171, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ZeusLayout.createSequentialGroup()
                        .addComponent(jLabel211, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField172, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ZeusLayout.createSequentialGroup()
                        .addComponent(jLabel212, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField173, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ZeusLayout.createSequentialGroup()
                        .addComponent(jLabel213, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField174, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ZeusLayout.createSequentialGroup()
                        .addComponent(jLabel214, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField175, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ZeusLayout.createSequentialGroup()
                        .addComponent(jLabel215, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField176, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ZeusLayout.createSequentialGroup()
                            .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField169))
                        .addGroup(ZeusLayout.createSequentialGroup()
                            .addComponent(jLabel209, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField170, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        ZeusLayout.setVerticalGroup(
            ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZeusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel207, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField169, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel209, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField170, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel210, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField171, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel211, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField172, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel212, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField173, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel213, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField174, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel214, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField175, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ZeusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel215, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField176, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Kimi.setBackground(java.awt.Color.red);

        jLabel216.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(205, 230, 0));
        jLabel216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel216.setText("KIMI");

        jLabel217.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel217.setText("Element");

        jLabel218.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel218.setText("Vie");

        jLabel219.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel219.setText("Attaque 1");

        jLabel220.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel220.setText("Attaque 2");

        jLabel221.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel221.setText("Attaque 3");

        jTextField177.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField177.setText("Glace");
        jTextField177.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField177ActionPerformed(evt);
            }
        });

        jTextField178.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField178.setText("1500");

        jTextField179.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField179.setText("150");

        jTextField180.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField180.setText("250");

        jTextField181.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField181.setText("600");
        jTextField181.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField181ActionPerformed(evt);
            }
        });

        jLabel222.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel222.setText("Attaque S");

        jLabel223.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel223.setText("Soin");

        jTextField182.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField182.setText("1000");

        jTextField183.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField183.setText("350");

        jLabel224.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel224.setText("Vitesse");

        jTextField184.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField184.setText("9");

        javax.swing.GroupLayout KimiLayout = new javax.swing.GroupLayout(Kimi);
        Kimi.setLayout(KimiLayout);
        KimiLayout.setHorizontalGroup(
            KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimiLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel216, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(KimiLayout.createSequentialGroup()
                        .addComponent(jLabel219, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField179, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KimiLayout.createSequentialGroup()
                        .addComponent(jLabel220, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField180, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KimiLayout.createSequentialGroup()
                        .addComponent(jLabel221, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField181, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KimiLayout.createSequentialGroup()
                        .addComponent(jLabel222, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField182, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KimiLayout.createSequentialGroup()
                        .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField183, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KimiLayout.createSequentialGroup()
                        .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField184, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, KimiLayout.createSequentialGroup()
                            .addComponent(jLabel217, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField177))
                        .addGroup(KimiLayout.createSequentialGroup()
                            .addComponent(jLabel218, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField178, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        KimiLayout.setVerticalGroup(
            KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel216, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel217, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField177, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel218, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField178, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel219, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField179, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel220, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField180, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel221, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField181, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel222, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField182, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField183, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(KimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField184, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Salameche.setBackground(java.awt.Color.red);

        jLabel225.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(205, 230, 0));
        jLabel225.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel225.setText("SALAMECHE");

        jLabel226.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel226.setText("Element");

        jLabel227.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel227.setText("Vie");

        jLabel228.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel228.setText("Attaque 1");

        jLabel229.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel229.setText("Attaque 2");

        jLabel230.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel230.setText("Attaque 3");

        jTextField185.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField185.setText("Feu");
        jTextField185.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField185ActionPerformed(evt);
            }
        });

        jTextField186.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField186.setText("2000");

        jTextField187.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField187.setText("200");

        jTextField188.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField188.setText("350");

        jTextField189.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField189.setText("425");
        jTextField189.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField189ActionPerformed(evt);
            }
        });

        jLabel231.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel231.setText("Attaque S");

        jLabel232.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel232.setText("Soin");

        jTextField190.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField190.setText("850");

        jTextField191.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField191.setText("425");

        jLabel233.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel233.setText("Vitesse");

        jTextField192.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField192.setText("7");

        javax.swing.GroupLayout SalamecheLayout = new javax.swing.GroupLayout(Salameche);
        Salameche.setLayout(SalamecheLayout);
        SalamecheLayout.setHorizontalGroup(
            SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalamecheLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel225, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SalamecheLayout.createSequentialGroup()
                        .addComponent(jLabel228, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField187, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalamecheLayout.createSequentialGroup()
                        .addComponent(jLabel229, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField188, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalamecheLayout.createSequentialGroup()
                        .addComponent(jLabel230, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField189, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalamecheLayout.createSequentialGroup()
                        .addComponent(jLabel231, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField190, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalamecheLayout.createSequentialGroup()
                        .addComponent(jLabel232, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField191, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalamecheLayout.createSequentialGroup()
                        .addComponent(jLabel233, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField192, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalamecheLayout.createSequentialGroup()
                            .addComponent(jLabel226, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField185))
                        .addGroup(SalamecheLayout.createSequentialGroup()
                            .addComponent(jLabel227, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField186, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        SalamecheLayout.setVerticalGroup(
            SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalamecheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel225, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel226, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField185, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel227, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField186, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel228, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField187, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel229, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField188, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel230, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField189, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel231, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField190, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel232, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField191, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(SalamecheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel233, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField192, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Chronos.setBackground(java.awt.Color.darkGray);

        jLabel234.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel234.setForeground(java.awt.Color.white);
        jLabel234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel234.setText("CHRONOS");

        jLabel235.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel235.setText("Element");

        jLabel236.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel236.setText("Vie");

        jLabel237.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel237.setText("Attaque 1");

        jLabel238.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel238.setText("Attaque 2");

        jLabel239.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel239.setText("Attaque 3");

        jTextField193.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField193.setText("Eau");
        jTextField193.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField193ActionPerformed(evt);
            }
        });

        jTextField194.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField194.setText("2500");

        jTextField195.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField195.setText("75");

        jTextField196.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField196.setText("200");

        jTextField197.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField197.setText("1000");
        jTextField197.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField197ActionPerformed(evt);
            }
        });

        jLabel240.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel240.setText("Attaque S");

        jLabel241.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel241.setText("Soin");

        jTextField198.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField198.setText("1600");

        jTextField199.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField199.setText("500");

        jLabel242.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel242.setText("Vitesse");

        jTextField200.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField200.setText("7");

        javax.swing.GroupLayout ChronosLayout = new javax.swing.GroupLayout(Chronos);
        Chronos.setLayout(ChronosLayout);
        ChronosLayout.setHorizontalGroup(
            ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChronosLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ChronosLayout.createSequentialGroup()
                        .addComponent(jLabel237, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField195, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChronosLayout.createSequentialGroup()
                        .addComponent(jLabel238, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField196, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChronosLayout.createSequentialGroup()
                        .addComponent(jLabel239, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField197, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChronosLayout.createSequentialGroup()
                        .addComponent(jLabel240, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField198, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChronosLayout.createSequentialGroup()
                        .addComponent(jLabel241, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField199, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChronosLayout.createSequentialGroup()
                        .addComponent(jLabel242, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField200, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ChronosLayout.createSequentialGroup()
                            .addComponent(jLabel235, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField193))
                        .addGroup(ChronosLayout.createSequentialGroup()
                            .addComponent(jLabel236, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField194, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        ChronosLayout.setVerticalGroup(
            ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChronosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel235, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField193, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel236, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField194, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel237, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField195, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel238, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField196, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel239, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField197, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel240, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField198, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel241, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField199, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChronosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel242, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Toph.setBackground(java.awt.Color.green);

        jLabel243.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel243.setForeground(new java.awt.Color(0, 155, 0));
        jLabel243.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel243.setText("TOPH");

        jLabel244.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel244.setText("Element");

        jLabel245.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel245.setText("Vie");

        jLabel246.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel246.setText("Attaque 1");

        jLabel247.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel247.setText("Attaque 2");

        jLabel248.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel248.setText("Attaque 3");

        jTextField201.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField201.setText("Terre");
        jTextField201.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField201ActionPerformed(evt);
            }
        });

        jTextField202.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField202.setText("2500");

        jTextField203.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField203.setText("250");

        jTextField204.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField204.setText("350");

        jTextField205.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField205.setText("400");
        jTextField205.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField205ActionPerformed(evt);
            }
        });

        jLabel249.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel249.setText("Attaque S");

        jLabel250.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel250.setText("Soin");

        jTextField206.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField206.setText("800");

        jTextField207.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField207.setText("300");

        jLabel251.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel251.setText("Vitesse");

        jTextField208.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField208.setText("7");

        javax.swing.GroupLayout TophLayout = new javax.swing.GroupLayout(Toph);
        Toph.setLayout(TophLayout);
        TophLayout.setHorizontalGroup(
            TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TophLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel243, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TophLayout.createSequentialGroup()
                        .addComponent(jLabel246, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField203, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TophLayout.createSequentialGroup()
                        .addComponent(jLabel247, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField204, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TophLayout.createSequentialGroup()
                        .addComponent(jLabel248, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField205, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TophLayout.createSequentialGroup()
                        .addComponent(jLabel249, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField206, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TophLayout.createSequentialGroup()
                        .addComponent(jLabel250, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField207, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TophLayout.createSequentialGroup()
                        .addComponent(jLabel251, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField208, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TophLayout.createSequentialGroup()
                            .addComponent(jLabel244, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField201))
                        .addGroup(TophLayout.createSequentialGroup()
                            .addComponent(jLabel245, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField202, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        TophLayout.setVerticalGroup(
            TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TophLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel243, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel244, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField201, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel245, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField202, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel246, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField203, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel247, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField204, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel248, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField205, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel249, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField206, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel250, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField207, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(TophLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel251, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField208, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Carapuce.setBackground(java.awt.Color.blue);

        jLabel252.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel252.setForeground(new java.awt.Color(122, 122, 255));
        jLabel252.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel252.setText("CARAPUCE");

        jLabel253.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel253.setText("Element");

        jLabel254.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel254.setText("Vie");

        jLabel255.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel255.setText("Attaque 1");

        jLabel256.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel256.setText("Attaque 2");

        jLabel257.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel257.setText("Attaque 3");

        jTextField209.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField209.setText("Eau");
        jTextField209.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField209ActionPerformed(evt);
            }
        });

        jTextField210.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField210.setText("1850");

        jTextField211.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField211.setText("185");
        jTextField211.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField211ActionPerformed(evt);
            }
        });

        jTextField212.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField212.setText("340");

        jTextField213.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField213.setText("480");
        jTextField213.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField213ActionPerformed(evt);
            }
        });

        jLabel258.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel258.setText("Attaque S");

        jLabel259.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel259.setText("Soin");

        jTextField214.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField214.setText("950");

        jTextField215.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField215.setText("400");

        jLabel260.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel260.setText("Vitesse");

        jTextField216.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField216.setText("8");

        javax.swing.GroupLayout CarapuceLayout = new javax.swing.GroupLayout(Carapuce);
        Carapuce.setLayout(CarapuceLayout);
        CarapuceLayout.setHorizontalGroup(
            CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CarapuceLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel252, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CarapuceLayout.createSequentialGroup()
                        .addComponent(jLabel255, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField211, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CarapuceLayout.createSequentialGroup()
                        .addComponent(jLabel256, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField212, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CarapuceLayout.createSequentialGroup()
                        .addComponent(jLabel257, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField213, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CarapuceLayout.createSequentialGroup()
                        .addComponent(jLabel258, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField214, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CarapuceLayout.createSequentialGroup()
                        .addComponent(jLabel259, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField215, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CarapuceLayout.createSequentialGroup()
                        .addComponent(jLabel260, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField216, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CarapuceLayout.createSequentialGroup()
                            .addComponent(jLabel253, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField209))
                        .addGroup(CarapuceLayout.createSequentialGroup()
                            .addComponent(jLabel254, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField210, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        CarapuceLayout.setVerticalGroup(
            CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CarapuceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel252, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel253, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField209, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel254, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField210, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel255, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField211, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel256, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField212, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel257, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField213, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel258, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField214, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel259, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField215, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CarapuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel260, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField216, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pikachu.setBackground(java.awt.Color.yellow);

        jLabel261.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel261.setForeground(java.awt.Color.red);
        jLabel261.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel261.setText("PIKACHU");

        jLabel262.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel262.setText("Element");

        jLabel263.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel263.setText("Vie");

        jLabel264.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel264.setText("Attaque 1");

        jLabel265.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel265.setText("Attaque 2");

        jLabel266.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel266.setText("Attaque 3");

        jTextField217.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField217.setText("Foudre");
        jTextField217.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField217ActionPerformed(evt);
            }
        });

        jTextField218.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField218.setText("1300");

        jTextField219.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField219.setText("125");

        jTextField220.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField220.setText("225");

        jTextField221.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField221.setText("900");
        jTextField221.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField221ActionPerformed(evt);
            }
        });

        jLabel267.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel267.setText("Attaque S");

        jLabel268.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel268.setText("Soin");

        jTextField222.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField222.setText("1250");

        jTextField223.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField223.setText("300");

        jLabel269.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel269.setText("Vitesse");

        jTextField224.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField224.setText("10");

        javax.swing.GroupLayout PikachuLayout = new javax.swing.GroupLayout(Pikachu);
        Pikachu.setLayout(PikachuLayout);
        PikachuLayout.setHorizontalGroup(
            PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PikachuLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel261, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PikachuLayout.createSequentialGroup()
                        .addComponent(jLabel264, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField219, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PikachuLayout.createSequentialGroup()
                        .addComponent(jLabel265, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField220, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PikachuLayout.createSequentialGroup()
                        .addComponent(jLabel266, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField221, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PikachuLayout.createSequentialGroup()
                        .addComponent(jLabel267, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField222, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PikachuLayout.createSequentialGroup()
                        .addComponent(jLabel268, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField223, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PikachuLayout.createSequentialGroup()
                        .addComponent(jLabel269, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField224, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PikachuLayout.createSequentialGroup()
                            .addComponent(jLabel262, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField217))
                        .addGroup(PikachuLayout.createSequentialGroup()
                            .addComponent(jLabel263, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField218, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        PikachuLayout.setVerticalGroup(
            PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PikachuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel261, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel262, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField217, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel263, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField218, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel264, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField219, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel265, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField220, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel266, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField221, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel267, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField222, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel268, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField223, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel269, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField224, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Quentin.setBackground(new java.awt.Color(255, 152, 0));

        jLabel270.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel270.setForeground(java.awt.Color.blue);
        jLabel270.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel270.setText("QUENTIN");

        jLabel271.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel271.setText("Element");

        jLabel272.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel272.setText("Vie");

        jLabel273.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel273.setText("Attaque 1");

        jLabel274.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel274.setText("Attaque 2");

        jLabel275.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel275.setText("Attaque 3");

        jTextField225.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField225.setText(" ");
        jTextField225.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField225ActionPerformed(evt);
            }
        });

        jTextField226.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField226.setText("2600");

        jTextField227.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField227.setText("300");

        jTextField228.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField228.setText("300");
        jTextField228.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField228ActionPerformed(evt);
            }
        });

        jTextField229.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField229.setText("1275");
        jTextField229.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField229ActionPerformed(evt);
            }
        });

        jLabel276.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel276.setText("Attaque S");

        jLabel277.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel277.setText("Soin");

        jTextField230.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField230.setText("2400");

        jTextField231.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField231.setText("500");

        jLabel278.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel278.setText("Vitesse");

        jTextField232.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField232.setText("7");

        javax.swing.GroupLayout QuentinLayout = new javax.swing.GroupLayout(Quentin);
        Quentin.setLayout(QuentinLayout);
        QuentinLayout.setHorizontalGroup(
            QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuentinLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel270, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(QuentinLayout.createSequentialGroup()
                        .addComponent(jLabel273, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField227, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QuentinLayout.createSequentialGroup()
                        .addComponent(jLabel274, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField228, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QuentinLayout.createSequentialGroup()
                        .addComponent(jLabel275, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField229, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QuentinLayout.createSequentialGroup()
                        .addComponent(jLabel276, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField230, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QuentinLayout.createSequentialGroup()
                        .addComponent(jLabel277, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField231, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QuentinLayout.createSequentialGroup()
                        .addComponent(jLabel278, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField232, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QuentinLayout.createSequentialGroup()
                            .addComponent(jLabel271, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField225))
                        .addGroup(QuentinLayout.createSequentialGroup()
                            .addComponent(jLabel272, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField226, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        QuentinLayout.setVerticalGroup(
            QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuentinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel270, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel271, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField225, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel272, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField226, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel273, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField227, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel274, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField228, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel275, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField229, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel276, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField230, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel277, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField231, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(QuentinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel278, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField232, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Mbappe.setBackground(java.awt.Color.blue);

        jLabel279.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel279.setForeground(new java.awt.Color(255, 255, 255));
        jLabel279.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel279.setText("MBAPPE");

        jLabel280.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel280.setText("Element");

        jLabel281.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel281.setText("Vie");

        jLabel282.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel282.setText("Attaque 1");

        jLabel283.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel283.setText("Attaque 2");

        jLabel284.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel284.setText("Attaque 3");

        jTextField233.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField233.setText("foot");
        jTextField233.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField233ActionPerformed(evt);
            }
        });

        jTextField234.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField234.setText("3100");

        jTextField235.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField235.setText("300");

        jTextField236.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField236.setText("300");

        jTextField237.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField237.setText("975");
        jTextField237.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField237ActionPerformed(evt);
            }
        });

        jLabel285.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel285.setText("Attaque S");

        jLabel286.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel286.setText("Soin");

        jTextField238.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField238.setText("2100");

        jTextField239.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField239.setText("500");

        jLabel287.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel287.setText("Vitesse");

        jTextField240.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField240.setText("10");

        javax.swing.GroupLayout MbappeLayout = new javax.swing.GroupLayout(Mbappe);
        Mbappe.setLayout(MbappeLayout);
        MbappeLayout.setHorizontalGroup(
            MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MbappeLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel279, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MbappeLayout.createSequentialGroup()
                        .addComponent(jLabel282, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField235, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MbappeLayout.createSequentialGroup()
                        .addComponent(jLabel283, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField236, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MbappeLayout.createSequentialGroup()
                        .addComponent(jLabel284, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField237, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MbappeLayout.createSequentialGroup()
                        .addComponent(jLabel285, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField238, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MbappeLayout.createSequentialGroup()
                        .addComponent(jLabel286, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField239, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MbappeLayout.createSequentialGroup()
                        .addComponent(jLabel287, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField240, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MbappeLayout.createSequentialGroup()
                            .addComponent(jLabel280, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField233))
                        .addGroup(MbappeLayout.createSequentialGroup()
                            .addComponent(jLabel281, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField234, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        MbappeLayout.setVerticalGroup(
            MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MbappeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel279, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel280, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField233, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel281, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel282, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField235, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel283, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField236, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel284, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField237, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel285, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField238, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel286, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField239, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MbappeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel287, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField240, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pesquet.setBackground(java.awt.Color.darkGray);

        jLabel288.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel288.setForeground(java.awt.Color.cyan);
        jLabel288.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel288.setText("THOMAS PESQUET");

        jLabel289.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel289.setText("Element");

        jLabel290.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel290.setText("Vie");

        jLabel291.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel291.setText("Attaque 1");

        jLabel292.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel292.setText("Attaque 2");

        jLabel293.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel293.setText("Attaque 3");

        jTextField241.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField241.setText("Space");
        jTextField241.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField241ActionPerformed(evt);
            }
        });

        jTextField242.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField242.setText("3100");

        jTextField243.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField243.setText("300");

        jTextField244.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField244.setText("300");

        jTextField245.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField245.setText("1275");
        jTextField245.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField245ActionPerformed(evt);
            }
        });

        jLabel294.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel294.setText("Attaque S");

        jLabel295.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel295.setText("Soin");

        jTextField246.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField246.setText("2400");

        jTextField247.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField247.setText("500");

        jLabel296.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel296.setText("Vitesse");

        jTextField248.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField248.setText("7");

        javax.swing.GroupLayout PesquetLayout = new javax.swing.GroupLayout(Pesquet);
        Pesquet.setLayout(PesquetLayout);
        PesquetLayout.setHorizontalGroup(
            PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PesquetLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel288, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PesquetLayout.createSequentialGroup()
                        .addComponent(jLabel291, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField243, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PesquetLayout.createSequentialGroup()
                        .addComponent(jLabel292, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField244, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PesquetLayout.createSequentialGroup()
                        .addComponent(jLabel293, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField245, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PesquetLayout.createSequentialGroup()
                        .addComponent(jLabel294, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField246, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PesquetLayout.createSequentialGroup()
                        .addComponent(jLabel295, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField247, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PesquetLayout.createSequentialGroup()
                        .addComponent(jLabel296, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField248, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PesquetLayout.createSequentialGroup()
                            .addComponent(jLabel289, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField241))
                        .addGroup(PesquetLayout.createSequentialGroup()
                            .addComponent(jLabel290, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField242, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        PesquetLayout.setVerticalGroup(
            PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PesquetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel288, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel289, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField241, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel290, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField242, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel291, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField243, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel292, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField244, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel293, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField245, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel294, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField246, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel295, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField247, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PesquetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel296, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField248, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Hades.setBackground(java.awt.Color.red);

        jLabel297.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel297.setForeground(java.awt.Color.darkGray);
        jLabel297.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel297.setText("HADES");

        jLabel298.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel298.setText("Element");

        jLabel299.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel299.setText("Vie");

        jLabel300.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel300.setText("Attaque 1");

        jLabel301.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel301.setText("Attaque 2");

        jLabel302.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel302.setText("Attaque 3");

        jTextField249.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField249.setText("Feu");
        jTextField249.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField249ActionPerformed(evt);
            }
        });

        jTextField250.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField250.setText("3000");

        jTextField251.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField251.setText("300");

        jTextField252.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField252.setText("525");

        jTextField253.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField253.setText("637.5");
        jTextField253.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField253ActionPerformed(evt);
            }
        });

        jLabel303.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel303.setText("Attaque S");

        jLabel304.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel304.setText("Soin");

        jTextField254.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField254.setText("1275");

        jTextField255.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField255.setText("637.5");

        jLabel305.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel305.setText("Vitesse");

        jTextField256.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField256.setText("6");

        javax.swing.GroupLayout HadesLayout = new javax.swing.GroupLayout(Hades);
        Hades.setLayout(HadesLayout);
        HadesLayout.setHorizontalGroup(
            HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HadesLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel297, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HadesLayout.createSequentialGroup()
                        .addComponent(jLabel300, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField251, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HadesLayout.createSequentialGroup()
                        .addComponent(jLabel301, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField252, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HadesLayout.createSequentialGroup()
                        .addComponent(jLabel302, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField253, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HadesLayout.createSequentialGroup()
                        .addComponent(jLabel303, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField254, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HadesLayout.createSequentialGroup()
                        .addComponent(jLabel304, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField255, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HadesLayout.createSequentialGroup()
                        .addComponent(jLabel305, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField256, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HadesLayout.createSequentialGroup()
                            .addComponent(jLabel298, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField249))
                        .addGroup(HadesLayout.createSequentialGroup()
                            .addComponent(jLabel299, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField250, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        HadesLayout.setVerticalGroup(
            HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel297, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel298, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField249, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel299, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField250, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel300, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField251, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel301, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField252, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel302, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField253, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel303, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField254, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel304, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField255, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(HadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel305, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField256, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Acteon.setBackground(java.awt.Color.green);

        jLabel306.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel306.setForeground(new java.awt.Color(0, 134, 0));
        jLabel306.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel306.setText("ACTEON");

        jLabel307.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel307.setText("Element");

        jLabel308.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel308.setText("Vie");

        jLabel309.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel309.setText("Attaque 1");

        jLabel310.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel310.setText("Attaque 2");

        jLabel311.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel311.setText("Attaque 3");

        jTextField257.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField257.setText("Nature");
        jTextField257.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField257ActionPerformed(evt);
            }
        });

        jTextField258.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField258.setText("2850");

        jTextField259.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField259.setText("285");

        jTextField260.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField260.setText("525");

        jTextField261.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField261.setText("667.5");
        jTextField261.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField261ActionPerformed(evt);
            }
        });

        jLabel312.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel312.setText("Attaque S");

        jLabel313.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel313.setText("Soin");

        jTextField262.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField262.setText("1387.5");

        jTextField263.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField263.setText("500");

        jLabel314.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel314.setText("Vitesse");

        jTextField264.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField264.setText("7");

        javax.swing.GroupLayout ActeonLayout = new javax.swing.GroupLayout(Acteon);
        Acteon.setLayout(ActeonLayout);
        ActeonLayout.setHorizontalGroup(
            ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActeonLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel306, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ActeonLayout.createSequentialGroup()
                        .addComponent(jLabel309, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField259, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ActeonLayout.createSequentialGroup()
                        .addComponent(jLabel310, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField260, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ActeonLayout.createSequentialGroup()
                        .addComponent(jLabel311, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField261, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ActeonLayout.createSequentialGroup()
                        .addComponent(jLabel312, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField262, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ActeonLayout.createSequentialGroup()
                        .addComponent(jLabel313, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField263, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ActeonLayout.createSequentialGroup()
                        .addComponent(jLabel314, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField264, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ActeonLayout.createSequentialGroup()
                            .addComponent(jLabel307, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField257))
                        .addGroup(ActeonLayout.createSequentialGroup()
                            .addComponent(jLabel308, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField258, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        ActeonLayout.setVerticalGroup(
            ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActeonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel306, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel307, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField257, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel308, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField258, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel309, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField259, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel310, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField260, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel311, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField261, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel312, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField262, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel313, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField263, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ActeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel314, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField264, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Chione.setBackground(java.awt.Color.cyan);

        jLabel315.setFont(new java.awt.Font("Freestyle Script", 3, 36)); // NOI18N
        jLabel315.setForeground(java.awt.Color.blue);
        jLabel315.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel315.setText("CHIONE");

        jLabel316.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel316.setText("Element");

        jLabel317.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel317.setText("Vie");

        jLabel318.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel318.setText("Attaque 1");

        jLabel319.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel319.setText("Attaque 2");

        jLabel320.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel320.setText("Attaque 3");

        jTextField265.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField265.setText("Eau");
        jTextField265.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField265ActionPerformed(evt);
            }
        });

        jTextField266.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField266.setText("2500");

        jTextField267.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField267.setText("75");

        jTextField268.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField268.setText("200");

        jTextField269.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField269.setText("1000");
        jTextField269.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField269ActionPerformed(evt);
            }
        });

        jLabel321.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel321.setText("Attaque S");

        jLabel322.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel322.setText("Soin");

        jTextField270.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField270.setText("1600");

        jTextField271.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField271.setText("500");

        jLabel323.setFont(new java.awt.Font("Garamond", 2, 18)); // NOI18N
        jLabel323.setText("Vitesse");

        jTextField272.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField272.setText("7");

        javax.swing.GroupLayout ChioneLayout = new javax.swing.GroupLayout(Chione);
        Chione.setLayout(ChioneLayout);
        ChioneLayout.setHorizontalGroup(
            ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChioneLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel315, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ChioneLayout.createSequentialGroup()
                        .addComponent(jLabel318, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField267, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChioneLayout.createSequentialGroup()
                        .addComponent(jLabel319, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField268, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChioneLayout.createSequentialGroup()
                        .addComponent(jLabel320, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField269, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChioneLayout.createSequentialGroup()
                        .addComponent(jLabel321, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField270, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChioneLayout.createSequentialGroup()
                        .addComponent(jLabel322, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField271, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChioneLayout.createSequentialGroup()
                        .addComponent(jLabel323, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField272, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ChioneLayout.createSequentialGroup()
                            .addComponent(jLabel316, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField265))
                        .addGroup(ChioneLayout.createSequentialGroup()
                            .addComponent(jLabel317, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField266, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        ChioneLayout.setVerticalGroup(
            ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChioneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel315, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel316, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField265, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel317, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField266, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel318, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField267, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel319, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField268, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel320, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField269, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel321, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField270, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel322, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField271, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ChioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel323, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField272, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuGame.setText("Game");
        barreDeMenu.add(menuGame);

        menuSettings.setText("Settings");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        menuSettings.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");
        menuSettings.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("jCheckBoxMenuItem4");
        menuSettings.add(jCheckBoxMenuItem4);

        barreDeMenu.add(menuSettings);

        setJMenuBar(barreDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(panPersos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 204, Short.MAX_VALUE)
                    .addComponent(panGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(panOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(panAPropos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 240, Short.MAX_VALUE)
                    .addComponent(panChoixI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 212, Short.MAX_VALUE)
                    .addComponent(panChoix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 210, Short.MAX_VALUE)
                    .addComponent(panFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 204, Short.MAX_VALUE)
                    .addComponent(panRegles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 206, Short.MAX_VALUE)
                    .addComponent(panRegles2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Poseidon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Michael, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 209, Short.MAX_VALUE)
                    .addComponent(Alex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Vegeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 209, Short.MAX_VALUE)
                    .addComponent(Adam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(GAÏA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Zeus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Kimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Salameche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Chronos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Toph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Carapuce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 207, Short.MAX_VALUE)
                    .addComponent(Pikachu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 207, Short.MAX_VALUE)
                    .addComponent(Quentin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Mbappe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Pesquet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Hades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Acteon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(Chione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
            .addComponent(panHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panPersos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panAPropos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panChoixI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panChoix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panRegles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panRegles2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Poseidon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Michael, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Alex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Vegeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Adam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GAÏA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Zeus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Kimi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Salameche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Chronos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Toph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Carapuce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Pikachu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Quentin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Mbappe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Pesquet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Hades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Acteon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Chione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp1MouseClicked
        if(g==false){//permettre de switcher de panel dans le menu
            panHome.setVisible(true);
            panPersos.setVisible(false);
            panOptions.setVisible(false);
            panAPropos.setVisible(false);
            panGame.setVisible(false);
            panChoixI.setVisible(false);
            panChoix.setVisible(false);
            panGameImage.setVisible(false);
            Michael.setVisible(false);
            Toph.setVisible(false);
            Carapuce.setVisible(false);
            Salameche.setVisible(false);
            Vegeta.setVisible(false);
            Pikachu.setVisible(false);
            Kimi.setVisible(false);
            Alex.setVisible(false);
            Adam.setVisible(false);
            Quentin.setVisible(false);
            Mbappe.setVisible(false);
            Pesquet.setVisible(false);
            GAÏA.setVisible(false);
            Hades.setVisible(false);
            Poseidon.setVisible(false);
            Acteon.setVisible(false);
            Zeus.setVisible(false);
            Chione.setVisible(false);
            Chronos.setVisible(false);
            jp1.setBackground(Color.white);
            jp2.setBackground(new Color(255,204,204));
            jp3.setBackground(new Color(255,204,204));
            jp4.setBackground(new Color(255,204,204));
        }else if(g==true){
            int response = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter?", "Confirmer", JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION){
                //nombre de joueurs initialisé
                n = 0;
                nombreJoueurs.setText("2");
                joueur2Name.setVisible(true);
                joueur2OK.setVisible(true);
                jLabel3.setVisible(true);
                
                c = 0; //remettre le compteur de persos choisis à 0
                
                //placer autre scène
                s = (int)(Math.random()*12);
                switch (s) {
                    case 0 -> panGameImage.setIcon(areneTerre);
                    case 1 -> panGameImage.setIcon(areneFeu);
                    case 2 -> panGameImage.setIcon(areneEau);
                    case 3 -> panGameImage.setIcon(areneNature);
                    case 4 -> panGameImage.setIcon(areneFoudre);
                    case 5 -> panGameImage.setIcon(areneGlace);
                    case 6 -> panGameImage.setIcon(ISS);
                    case 7 -> panGameImage.setIcon(sahara);
                    case 8 -> panGameImage.setIcon(eiffel);
                    case 9 -> panGameImage.setIcon(windows);
                    case 10 -> panGameImage.setIcon(BMC);
                    case 11 -> panGameImage.setIcon(konoha);
                    default -> {
                    }
                }
                
                //ne faire apparaître que le panel Home
                panHome.setVisible(true);
                panPersos.setVisible(false);
                panOptions.setVisible(false);
                panAPropos.setVisible(false);
                panGame.setVisible(false);
                panChoixI.setVisible(false);
                panChoix.setVisible(false);
                panFin.setVisible(false);
                jButton3.setVisible(false);
                jButton4.setVisible(false);
                
                        
                //mettre HOME en blanc (selectionné)
                jp1.setBackground(Color.white);
                jp2.setBackground(new Color(255,204,204));
                jp3.setBackground(new Color(255,204,204));
                jp4.setBackground(new Color(255,204,204));
                
                panGameImage.setVisible(false);
                nombreJoueurs.setVisible(true);
                joueur1Name.setVisible(true);
                joueur1OK.setVisible(true);
                joueur2Name.setVisible(true);
                joueur2OK.setVisible(true);
                startGame.setVisible(true);
                startGame.setEnabled(false);
                nom1 = false;
                nom2 = false;
                
                terre.setEnabled(true);
                feu.setEnabled(true);
                eau.setEnabled(true);
                nature.setEnabled(true);
                foudre.setEnabled(true);
                glace.setEnabled(true);
                
                combattre.setVisible(false);
                i=1;
                j=1;
                
                //choisir autres 3emes combattants
                c3j1 = (int)(Math.random()*14);
                c3j2 = (int)(Math.random()*14);
                switch (c3j1) {
                    case 0 -> comb3j1.setIcon(marchalot);
                    case 1 -> comb3j1.setIcon(alexandre);
                    case 2 -> comb3j1.setIcon(quentin);
                    case 3 -> comb3j1.setIcon(adam);
                    case 4 -> comb3j1.setIcon(mbappe);
                    case 5 -> comb3j1.setIcon(mj);
                    case 6 -> comb3j1.setIcon(pesquet);
                    case 7 -> comb3j1.setIcon(gaïa);
                    case 8 -> comb3j1.setIcon(hades);
                    case 9 -> comb3j1.setIcon(poseidon);
                    case 10 -> comb3j1.setIcon(acteon);
                    case 11 -> comb3j1.setIcon(zeus);
                    case 12 -> comb3j1.setIcon(chione);
                    case 13 -> comb3j1.setIcon(cronos);
                }  
        
                switch (c3j2) {
                    case 0 -> comb3j2.setIcon(marchalot);
                    case 1 -> comb3j2.setIcon(alexandre);
                    case 2 -> comb3j2.setIcon(quentin);
                    case 3 -> comb3j2.setIcon(adam);
                    case 4 -> comb3j2.setIcon(mbappe);
                    case 5 -> comb3j2.setIcon(mj);
                    case 6 -> comb3j2.setIcon(pesquet);
                    case 7 -> comb3j2.setIcon(gaïa);
                    case 8 -> comb3j2.setIcon(hades);
                    case 9 -> comb3j2.setIcon(poseidon);
                    case 10 -> comb3j2.setIcon(acteon);
                    case 11 -> comb3j2.setIcon(zeus);
                    case 12 -> comb3j2.setIcon(chione);
                    case 13 -> comb3j2.setIcon(cronos);
                }
                
                // pour repermettre de changer de panel
                g=false;

                premierClick1 = 0;
                premierClick2 = 0;
                premierClick3 = 0;
                premierClick4 = 0;
                premierClick5 = 0;
                premierClick6 = 0;
                comb1j1.setBorder(noborder);
                comb2j1.setBorder(noborder);
                comb3j1.setBorder(noborder);
                comb1j2.setBorder(noborder);
                comb2j2.setBorder(noborder);
                comb3j2.setBorder(noborder);
                comb1j1.setEnabled(true);
                comb2j1.setEnabled(true);
                comb3j1.setEnabled(true);
                comb1j2.setEnabled(true);
                comb2j2.setEnabled(true);
                comb3j2.setEnabled(true);
                sw = 0;
                startPanChoix.setEnabled(false);
                pret1 = false;
                pret2 = false;
                
                p3_1 = new Personnage(7+c3j1);
                p3_2 = new Personnage(7+c3j2);
                
                powUp1.setVisible(false);
                powUp2.setVisible(false);
                actif1 = false;
                actif2 = false;
                
                b1j1=true;
                b2j1=true;
                b3j1=true;
                b1j2=true;
                b2j2=true;
                b3j2=true;
                
                kill_1 = 0;
                kill_2 = 0;
                
                charge1 = 0;
                charge2 = 0;
                jProgressBar3.setValue(0);
                jProgressBar4.setValue(0);
                
                combat = false;
                tour = 0;
                        
            }
        }
    }//GEN-LAST:event_jp1MouseClicked

    private void jp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp2MouseClicked
        //aller au panel Personnages tant que le jeu n'est pas lancé
        if(g==false){
            panHome.setVisible(false);
            panPersos.setVisible(true);
            panOptions.setVisible(false);
            panAPropos.setVisible(false);
            panGameImage.setVisible(false);
            jp2.setBackground(Color.white);
            jp1.setBackground(new Color(255,204,204));
            jp3.setBackground(new Color(255,204,204));
            jp4.setBackground(new Color(255,204,204));
        }
    }//GEN-LAST:event_jp2MouseClicked

    private void jp3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp3MouseClicked
        if(g==false){
            panHome.setVisible(false);
            panPersos.setVisible(false);
            panOptions.setVisible(true);
            panAPropos.setVisible(false);
            panGame.setVisible(false);
            panGameImage.setVisible(false);
            jp3.setBackground(Color.white);
            jp1.setBackground(new Color(255,204,204));
            jp2.setBackground(new Color(255,204,204));
            jp4.setBackground(new Color(255,204,204));
        }
    }//GEN-LAST:event_jp3MouseClicked

    private void jp4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp4MouseClicked
        if(g==false){
            panHome.setVisible(false);
            panPersos.setVisible(false);
            panOptions.setVisible(false);
            panAPropos.setVisible(true);
            panGame.setVisible(false);
            panGameImage.setVisible(false);
            jp4.setBackground(Color.white);
            jp1.setBackground(new Color(255,204,204));
            jp2.setBackground(new Color(255,204,204));
            jp3.setBackground(new Color(255,204,204));
        }
    }//GEN-LAST:event_jp4MouseClicked

    private void joueur1NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joueur1NameActionPerformed
        
    }//GEN-LAST:event_joueur1NameActionPerformed

    private void joueur2NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joueur2NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_joueur2NameActionPerformed

    private void joueur2OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joueur2OKActionPerformed
        nameJ2 = joueur2Name.getText();
        nom2 = true;
        if((nom1 && nom2)) startGame.setEnabled(true);
    }//GEN-LAST:event_joueur2OKActionPerformed

    private void nombreJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreJoueursActionPerformed
        if(n%2==1){
            nombreJoueurs.setText("1");
            joueur2Name.setVisible(false);
            joueur2OK.setVisible(false);
            jLabel3.setVisible(false);
            jLabel5.setText("Ici, apparaîtront les actions de l'ordi");
        }else if(n%2==0){ //n initialement 0;
            nombreJoueurs.setText("2");
            joueur2Name.setVisible(true);
            joueur2OK.setVisible(true);
            jLabel3.setVisible(true);
            jLabel5.setText("Ici, apparaîtront les actions du joueur 2");
        }
        //à chaque fois demander le nom quand nombre de joueurs change
        nom1 = false;
        nom2 = false;
        startGame.setEnabled(false);
        n++; //n s'incrémente et le cas change
    }//GEN-LAST:event_nombreJoueursActionPerformed

    private void joueur1NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_joueur1NameMouseClicked
        joueur1Name.setText("");//"Joueur 1" disparait en cliquant 
    }//GEN-LAST:event_joueur1NameMouseClicked

    private void joueur2NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_joueur2NameMouseClicked
        joueur2Name.setText("");
    }//GEN-LAST:event_joueur2NameMouseClicked

    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameActionPerformed
        //ajouter musique en boucle
        int musique = (int)(Math.random()*3+1);
        music musicObject = new music();
        partie++;
        if (partie == 1){//ne l'ajouter qu'au début du jeu
            switch (musique){
                case 1 -> musicObject.playMusicLoop("Theme_1.wav");
                case 2 -> musicObject.playMusicLoop("Theme_2.wav");
                case 3 -> musicObject.playMusicLoop("Theme_3.wav");
            }
        }
        //afficher le panel règles de jeu
        panHome.setVisible(false);
        panGame.setVisible(false);
        panRegles.setVisible(true);
        panRegles2.setVisible(false);
        jButton4.setVisible(true);
        panChoixI.setVisible(false);
        panChoix.setVisible(false);
        panGameImage.setVisible(false);
        /*instructionsChoixI1.setText("Bonjour, "+ nameJ1 + " et " + nameJ2 + ".");
        instructionsChoixI3.setText(nameJ1 + ", à vous de choisir ");*/
        jp1.setBackground(new Color(255,204,204));
        jp2.setBackground(new Color(255,204,204));
        jp3.setBackground(new Color(255,204,204));
        jp4.setBackground(new Color(255,204,204));
        g = true;
        
        if(n%2==0){
            instructionsChoixI1.setText("Bonjour, "+ nameJ1 + " et " + nameJ2 + ".");
            instructionsChoixI3.setText(nameJ1 + ", à vous de choisir ");
        }else{
            instructionsChoixI1.setText("Bonjour, "+ nameJ1 + ".");
            instructionsChoixI3.setText(" Choisissez un combattant ");
        }
        
    }//GEN-LAST:event_startGameActionPerformed

    private void joueur1OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joueur1OKActionPerformed
        nameJ1 = joueur1Name.getText();
        nom1 = true;
        if((nom1 && nom2)||(n%2==0 && nom1)) startGame.setEnabled(true);
    }//GEN-LAST:event_joueur1OKActionPerformed

    private void combattreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combattreActionPerformed
        //afficher panel choix des combattants
        panChoix.setVisible(true);
        panHome.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panGameImage.setVisible(false);
        panChoixI.setVisible(false);
    }//GEN-LAST:event_combattreActionPerformed

    private void glaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glaceActionPerformed
        //permettre de créer un perso et l'attribuer au joueur après l'avoir choisi
        switch (j) {
            case 1 -> p1_1 = new Personnage(6);
            case 2 -> p1_2 = new Personnage(6);
            case 3 -> p2_1 = new Personnage(6);
            case 4 -> p2_2 = new Personnage(6);
        }      
        j++;//incrémenter j pour créer le personnage suivant qui sera choisi par le joueur adverse
        
        glace.setEnabled(false);//empêcher ce personnage d'être choisi de nouveau
        
        comb = kimi; // comb devient l'image du personnage
        
        //placer l'image de ce personnage sur le panel choix au bon endroit
        switch (i) {
            case 1 -> comb1j1.setIcon(comb);
            case 2 -> comb1j2.setIcon(comb);
            case 3 -> comb2j1.setIcon(comb);
            case 4 -> comb2j2.setIcon(comb);
        }
        c++; //incrémenter c pour donner la main à l'autre joueur de choisir
        i++; //incrémenter i pour pouvoir faire de même pour l'autre joueur (placer image)
        
        //conditions pour faire le tour à tour dans le choix initial
        if(c%2==0){
            panChoixI.setBackground(Color.RED);
            instructionsChoixI3.setText(nameJ1 + ", à vous de choisir ");
        }else{
            panChoixI.setBackground(Color.blue);
            instructionsChoixI3.setText(nameJ2 + ", à vous de choisir ");
        }
        if(c==4){
            //fin des choix et possibilité de commencer à choisir qui utiliser pour les combats
            combattre.setVisible(true);
            terre.setEnabled(false);
            feu.setEnabled(false);
            eau.setEnabled(false);
            nature.setEnabled(false);
            foudre.setEnabled(false);
            glace.setEnabled(false);
            instructionsChoixI3.setText("Vous pouvez commencer");
            instructionsChoixI1.setText(" ");
            instructionsChoixI2.setText(" ");
            instructionsChoixI4.setText(" ");
        }
    }//GEN-LAST:event_glaceActionPerformed

    private void foudreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foudreActionPerformed
        //commenté dans glaceActionPerformed
        switch (j) {
            case 1 -> p1_1 = new Personnage(5);
            case 2 -> p1_2 = new Personnage(5);
            case 3 -> p2_1 = new Personnage(5);
            case 4 -> p2_2 = new Personnage(5);
        }      
        j++;
        
        foudre.setEnabled(false);
        comb = pikachu;
        switch (i) {
            case 1 -> comb1j1.setIcon(comb);
            case 2 -> comb1j2.setIcon(comb);
            case 3 -> comb2j1.setIcon(comb);
            case 4 -> comb2j2.setIcon(comb);
        }
        c++;
        i++;
        if(c%2==0){
            panChoixI.setBackground(Color.RED);
            instructionsChoixI3.setText(nameJ1 + ", à vous de choisir ");
        }else{
            panChoixI.setBackground(Color.blue);
            instructionsChoixI3.setText(nameJ2 + ", à vous de choisir ");
        }
        if(c==4){
            combattre.setVisible(true);
            terre.setEnabled(false);
            feu.setEnabled(false);
            eau.setEnabled(false);
            nature.setEnabled(false);
            foudre.setEnabled(false);
            glace.setEnabled(false);
            instructionsChoixI3.setText("Vous pouvez commencer");
            instructionsChoixI1.setText(" ");
            instructionsChoixI2.setText(" ");
            instructionsChoixI4.setText(" ");
        }
    }//GEN-LAST:event_foudreActionPerformed

    private void natureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_natureActionPerformed
        //commenté dans glaceActionPerformed
        switch (j) {
            case 1 -> p1_1 = new Personnage(4);
            case 2 -> p1_2 = new Personnage(4);
            case 3 -> p2_1 = new Personnage(4);
            case 4 -> p2_2 = new Personnage(4);
        }      
        j++;
        
        nature.setEnabled(false);
        comb = vegeta;
        switch (i) {
            case 1 -> comb1j1.setIcon(comb);
            case 2 -> comb1j2.setIcon(comb);
            case 3 -> comb2j1.setIcon(comb);
            case 4 -> comb2j2.setIcon(comb);
        }
        c++;
        i++;
        if(c%2==0){
            panChoixI.setBackground(Color.RED);
            instructionsChoixI3.setText(nameJ1 + ", à vous de choisir ");
        }else{
            panChoixI.setBackground(Color.blue);
            instructionsChoixI3.setText(nameJ2 + ", à vous de choisir ");
        }
        if(c==4){
            combattre.setVisible(true);
            terre.setEnabled(false);
            feu.setEnabled(false);
            eau.setEnabled(false);
            nature.setEnabled(false);
            foudre.setEnabled(false);
            glace.setEnabled(false);
            instructionsChoixI3.setText("Vous pouvez commencer");
            instructionsChoixI1.setText(" ");
            instructionsChoixI2.setText(" ");
            instructionsChoixI4.setText(" ");
        }
    }//GEN-LAST:event_natureActionPerformed

    private void eauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eauActionPerformed
        //commenté dans glaceActionPerformed
        switch (j) {
            case 1 -> p1_1 = new Personnage(3);
            case 2 -> p1_2 = new Personnage(3);
            case 3 -> p2_1 = new Personnage(3);
            case 4 -> p2_2 = new Personnage(3);
        }      
        j++;
        
        eau.setEnabled(false);
        comb = carapuce;
        switch (i) {
            case 1 -> comb1j1.setIcon(comb);
            case 2 -> comb1j2.setIcon(comb);
            case 3 -> comb2j1.setIcon(comb);
            case 4 -> comb2j2.setIcon(comb);
        }
        c++;
        i++;
        if(c%2==0){
            panChoixI.setBackground(Color.RED);
            instructionsChoixI3.setText(nameJ1 + ", à vous de choisir ");
        }else{
            panChoixI.setBackground(Color.blue);
            instructionsChoixI3.setText(nameJ2 + ", à vous de choisir ");
        }
        if(c==4){
            combattre.setVisible(true);
            terre.setEnabled(false);
            feu.setEnabled(false);
            eau.setEnabled(false);
            nature.setEnabled(false);
            foudre.setEnabled(false);
            glace.setEnabled(false);
            instructionsChoixI3.setText("Vous pouvez commencer");
            instructionsChoixI1.setText(" ");
            instructionsChoixI2.setText(" ");
            instructionsChoixI4.setText(" ");
        }
    }//GEN-LAST:event_eauActionPerformed

    private void feuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feuActionPerformed
        //commenté dans glaceActionPerformed
        switch (j) {
            case 1 -> p1_1 = new Personnage(2);
            case 2 -> p1_2 = new Personnage(2);
            case 3 -> p2_1 = new Personnage(2);
            case 4 -> p2_2 = new Personnage(2);
        }      
        j++;
        
        feu.setEnabled(false);
        comb = salameche;
        switch (i) {
            case 1 -> comb1j1.setIcon(comb);
            case 2 -> comb1j2.setIcon(comb);
            case 3 -> comb2j1.setIcon(comb);
            case 4 -> comb2j2.setIcon(comb);
        }
        c++;
        i++;
        if(c%2==0){
            panChoixI.setBackground(Color.RED);
            instructionsChoixI3.setText(nameJ1 + ", à vous de choisir ");
        }else{
            panChoixI.setBackground(Color.blue);
            instructionsChoixI3.setText(nameJ2 + ", à vous de choisir ");
        }
        if(c==4){
            combattre.setVisible(true);
            terre.setEnabled(false);
            feu.setEnabled(false);
            eau.setEnabled(false);
            nature.setEnabled(false);
            foudre.setEnabled(false);
            glace.setEnabled(false);
            instructionsChoixI3.setText("Vous pouvez commencer");
            instructionsChoixI1.setText(" ");
            instructionsChoixI2.setText(" ");
            instructionsChoixI4.setText(" ");
        }
    }//GEN-LAST:event_feuActionPerformed

    private void terreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terreActionPerformed
        //commenté dans glaceActionPerformed
        switch (j) {
            case 1 -> p1_1 = new Personnage(1);
            case 2 -> p1_2 = new Personnage(1);
            case 3 -> p2_1 = new Personnage(1);
            case 4 -> p2_2 = new Personnage(1);
        }      
        j++;
        
        terre.setEnabled(false);
        comb = toph;
        switch (i) {
            case 1 -> comb1j1.setIcon(comb);
            case 2 -> comb1j2.setIcon(comb);
            case 3 -> comb2j1.setIcon(comb);
            case 4 -> comb2j2.setIcon(comb);
        }
        c++;
        i++;
        if(c%2==0){
            panChoixI.setBackground(Color.RED);
            instructionsChoixI3.setText(nameJ1 + ", à vous de choisir ");
        }else{
            panChoixI.setBackground(Color.blue);
            instructionsChoixI3.setText(nameJ2 + ", à vous de choisir ");
        }
        if(c==4){
            combattre.setVisible(true);
            terre.setEnabled(false);
            feu.setEnabled(false);
            eau.setEnabled(false);
            nature.setEnabled(false);
            foudre.setEnabled(false);
            glace.setEnabled(false);
            instructionsChoixI3.setText("Vous pouvez commencer");
            instructionsChoixI1.setText(" ");
            instructionsChoixI2.setText(" ");
            instructionsChoixI4.setText(" ");
            }
    }//GEN-LAST:event_terreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comb1j1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comb1j1MouseClicked
        //choisir le combattant 1 du joueur 1
        if(b1j1 && (sw==1 || (sw ==0 && j1perd) || !combat)){
            startPanChoix.setEnabled(false);
            //
            if(b2j1)comb2j1.setBorder(noborder);
            if(b3j1)comb3j1.setBorder(noborder);
            if(premierClick1 == 0)clickCh = 1;
        
            //changer l'état de la bordure appliquée et dire si le joueur est prêt
            if(clickCh%2 == 1){
                comb1j1.setBorder(lineborder);
                pret1 = true;
            }else{
                comb1j1.setBorder(noborder);
                pret1 = false;
            }
            clickCh++;
        
            premierClick1++;
            premierClick2 = 0;
            premierClick3 = 0;
            
            a=1;// on choisit quel personnage utiliser
            if(pret1 && pret2)startPanChoix.setEnabled(true);//si les 2 joueurs sont prêrs activer start
            sw = 0;//réinitialiser variable permettant le switch
        }
    }//GEN-LAST:event_comb1j1MouseClicked

    private void comb2j1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comb2j1MouseClicked
        if(b2j1 && (sw==1 || (sw ==0 && j1perd) || !combat)){
        startPanChoix.setEnabled(false);
        if(b3j1)comb3j1.setBorder(noborder);
        if(b1j1)comb1j1.setBorder(noborder);
        if(premierClick2 == 0)clickCh = 1;
        if(clickCh%2 == 1){
            comb2j1.setBorder(lineborder);
            pret1 = true;
        }else{
            comb2j1.setBorder(noborder);
            pret1 = false;
        }
        clickCh++;
        premierClick2++;
        premierClick1 = 0;
        premierClick3 = 0;
        if(pret1 && pret2)startPanChoix.setEnabled(true);
        a=2;
        sw = 0;
        }
    }//GEN-LAST:event_comb2j1MouseClicked

    private void comb3j1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comb3j1MouseClicked
        if(b3j1 && (sw==1 || (sw ==0 && j1perd) || !combat)){
            startPanChoix.setEnabled(false);
            if(b2j1)comb2j1.setBorder(noborder);
            if(b1j1)comb1j1.setBorder(noborder);
            if(premierClick3 == 0)clickCh = 1;
            if(clickCh%2 == 1){
                comb3j1.setBorder(lineborder);
                pret1 = true;
            }else{
                comb3j1.setBorder(noborder);
                pret1 = false;
            }
            clickCh++;
            premierClick3++;
            premierClick2 = 0;
            premierClick1 = 0;
            if(pret1 && pret2)startPanChoix.setEnabled(true);
            a=3;
            sw = 0;
        }
    }//GEN-LAST:event_comb3j1MouseClicked

    private void comb1j2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comb1j2MouseClicked
        if(b1j2 && (sw==2 || (sw ==0  && j2perd) || !combat)){
        startPanChoix.setEnabled(false);
        if(b2j2)comb2j2.setBorder(noborder);
        if(b3j2)comb3j2.setBorder(noborder);
        
        if(premierClick4 == 0)clickCh = 1;
        if(clickCh%2 == 1){
            comb1j2.setBorder(lineborder);
            pret2 = true;
        }else{
            comb1j2.setBorder(noborder);
            pret2 = false;
        }
        clickCh++;
        premierClick4++;
        premierClick5 = 0;
        premierClick6 = 0;
        if(pret1 && pret2)startPanChoix.setEnabled(true);
        b=1;
        sw = 0;
        }
    }//GEN-LAST:event_comb1j2MouseClicked

    private void comb2j2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comb2j2MouseClicked
        if(b2j2 && (sw==2 || (sw ==0  && j2perd) || !combat)){
        startPanChoix.setEnabled(false);
        if(b1j2)comb1j2.setBorder(noborder);
        if(b3j2)comb3j2.setBorder(noborder);
        
        if(premierClick5 == 0)clickCh = 1;
        if(clickCh%2 == 1){
            comb2j2.setBorder(lineborder);
            pret2 = true;
        }else{
            comb2j2.setBorder(noborder);
            pret2 = false;
        }
        clickCh++;
        premierClick5++;
        premierClick4 = 0;
        premierClick6 = 0;
        if(pret1 && pret2)startPanChoix.setEnabled(true);
        b=2;
        sw = 0;
        }
    }//GEN-LAST:event_comb2j2MouseClicked

    private void comb3j2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comb3j2MouseClicked
        if(b3j2 && (sw==2 || (sw ==0  && j2perd) || !combat)){
        startPanChoix.setEnabled(false);
        if(b1j2)comb1j2.setBorder(noborder);
        if(b2j2)comb2j2.setBorder(noborder);
        if(premierClick6 == 0)clickCh = 1;
        if(clickCh%2 == 1){
            comb3j2.setBorder(lineborder);
            pret2 = true;
        }else{
            comb3j2.setBorder(noborder);
            pret2 = false;
        }
        clickCh++;
        premierClick6++;
        premierClick4 = 0;
        premierClick5 = 0;
        if(pret1 && pret2)startPanChoix.setEnabled(true);
        b=3;
        sw =0;
        }
    }//GEN-LAST:event_comb3j2MouseClicked

    private void startPanChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startPanChoixActionPerformed
        
        combat = true;
        
        panChoix.setVisible(false);
        panGame.setVisible(true);
        panGameImage.setVisible(true);
        
        //on remplace pj1 par le personnage selectionné par le joueur 1
        switch (a){
            case 1 -> pj1 = p1_1;
            case 2 -> pj1 = p2_1;
            case 3 -> pj1 = p3_1;
        }
        
        //on remplace pj2 par le personnage selectionné par le joueur 2
        switch (b){
            case 1 -> pj2 = p1_2;
            case 2 -> pj2 = p2_2;
            case 3 -> pj2 = p3_2;
        }
        
        
        
        j1.setIcon(pj1.photo);
        j2.setIcon(pj2.photo);
        
        switch (tour) {
            case 0 -> {
                if(pj1.vitesse>pj2.vitesse){
                    jComboBox1.setEnabled(true);
                    jComboBox2.setEnabled(false);
                }else{
                    jComboBox2.setEnabled(true);
                    jComboBox1.setEnabled(false);
                }
            }
            case 1 -> {
                jComboBox1.setEnabled(true);
                jComboBox2.setEnabled(false);
            }
            case 2 -> {
                jComboBox2.setEnabled(true);
                jComboBox1.setEnabled(false);
            }
            default -> {
            }
        }
        
        Personnage temp1 = new Personnage(pj1.element);
        jProgressBar1.setValue((int)(pj1.vie/temp1.vie*100));
        Personnage temp2 = new Personnage(pj2.element);
        jProgressBar2.setValue((int)(pj2.vie/temp2.vie*100));
        
        powUp2.setVisible(false);
        powUp1.setVisible(false);
        
        
        
        pj1.majAtt(pj2.nomElement);
        pj2.majAtt(pj1.nomElement);
        
        
        
        
        
    }//GEN-LAST:event_startPanChoixActionPerformed

    private void panGameImageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panGameImageKeyPressed
    }//GEN-LAST:event_panGameImageKeyPressed

    private void powUp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powUp2ActionPerformed
        //permet d'augmenter les stats du personnage quand il active son domaine
        panGameImage.setIcon(pj2.background);
        pj2.sound(); // chaque domaine a un son qui va avec (sauf qu'avec l'ajout du son en continu, il est dur de le remarquer)
        pj2.picture(j2); // change la photo de quelques persos 
        pj2.att1*=2;
        pj2.att2*=2;
        pj2.att3*=2;
        powUp2.setVisible(false); // désactiver le bouton
        actif2 = true;
        active2 = true;
        //permet de désactiver le domaine de l'adversaire quand le joueur active le sien
        if(actif1 == true){
            pj1.att1/=2;
            pj1.att2/=2;
            pj1.att3/=2;
            actif1 = false;
        }
    }//GEN-LAST:event_powUp2ActionPerformed

    private void powUp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powUp1ActionPerformed
        //commenté dans powUp2ActionPerformed
        panGameImage.setIcon(pj1.background);
        pj1.sound();
        pj1.picture(j1);
        pj1.att1*=2;
        pj1.att2*=2;
        pj1.att3*=2;
        powUp1.setVisible(false);
        actif1 = true;
        if(actif2 == true){
            pj2.att1/=2;
            pj2.att2/=2;
            pj2.att3/=2;
            actif2 = false;
        }
        
    }//GEN-LAST:event_powUp1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        int rate = (int)(Math.random()*10);
        
        selectedAttack = jComboBox2.getSelectedItem().toString();
        sw = 0;
        
        if(selectedAttack == "Charger"){
            
            if(charge2 == 5){
                jLabel5.setText("L'attaque spéciale est déjà chargée");
            }else{
                charge2++;
                jProgressBar3.setValue(charge2*20);
                jComboBox2.setEnabled(false);
                jComboBox1.setEnabled(true);
                if(pj1.limAtt3%3 == 0 ) att3pret1 = true;
                jLabel5.setText(pj2.nom + " choisit de charger");
            }
        }else if(selectedAttack == "Attaque 1"){
            
            if(rate == 9){
                if(pj2.limAtt3%3 != 0 ) pj2.limAtt3++; //si l'attaque 3 n'est pas encore chargée, on la charge
                if(pj1.limAtt3%3 == 0 ) att3pret1 = true;
                jLabel5.setText(pj2.nom + " rate sa cible");
                jComboBox2.setEnabled(false);
                jComboBox1.setEnabled(true);
            }else{
                if(pj2.limAtt3%3 != 0 ) pj2.limAtt3++; //si l'attaque 3 n'est pas encore chargée, on la charge
                if(pj1.limAtt3%3 == 0 ) att3pret1 = true; //si l'attaque de l'adversaire est chargée on l'active
                pj1.vie -= pj2.att1; //on soustrait les points de vie à l'adversaire
                jComboBox2.setEnabled(false);
                jComboBox1.setEnabled(true);//on donne la main à l'adversaire
                jLabel5.setText(pj2.nom + " utilise Attaque 1 : " + pj2.nomAttaque1 + " qui est une attaque physique");
            }
            
        }else if(selectedAttack == "Attaque 2"){
            
            if(rate == 9){
                if(pj2.limAtt3%3 != 0 ) pj2.limAtt3++;
                if(pj1.limAtt3%3 == 0 ) att3pret1 = true;
                jLabel5.setText(pj2.nom + " rate sa cible");
                jComboBox2.setEnabled(false);
                jComboBox1.setEnabled(true);
            }else{
                if(pj2.limAtt3%3 != 0 ) pj2.limAtt3++;
                if(pj1.limAtt3%3 == 0 ) att3pret1 = true;
                pj1.vie -= pj2.att2;
                jComboBox2.setEnabled(false);
                jComboBox1.setEnabled(true);
                jLabel5.setText(pj2.nom + " utilise Attaque 2 : " + pj2.nomAttaque2 + " qui est une attaque " + pj2.nomElement);
            }
            
        }else if(selectedAttack == "Attaque 3"){
            
            if(att3pret2){
                if(rate == 9){
                    pj2.limAtt3++;// en utilisant l'attaque 3, on la décharge
                    jLabel5.setText(pj2.nom + " rate sa cible");
                    if(pj1.limAtt3%3 == 0 ) att3pret1 = true;
                    jComboBox2.setEnabled(false);
                    jComboBox1.setEnabled(true);
                    att3pret2 = false;//pour désactiver l'att3
                }else{
                    pj2.limAtt3++;// en utilisant l'attaque 3, on la décharge
                    pj1.vie -= pj2.att3;
                    if(pj1.limAtt3%3 == 0 ) att3pret1 = true;
                    jComboBox2.setEnabled(false);
                    jComboBox1.setEnabled(true);
                    att3pret2 = false;//pour désactiver l'att3
                    jLabel5.setText(pj2.nom + " utilise Attaque 3 : " + pj2.nomAttaque3 + " qui est une attaque " + pj2.nomElement);
                }
            }else{
                jLabel5.setText("attendez encore "+ (3-(pj2.limAtt3%3)) +" tour(s) avant d'utiliser cette attaque");
            }
        }else if(selectedAttack == "Attaque S"){
            
            if(charge2 == 5){
                charge2 = 0;
                jProgressBar3.setValue(0);
                if(pj2.limAtt3%3 != 0 ) pj2.limAtt3++;
                if(pj1.limAtt3%3 == 0 ) att3pret1 = true;
                pj2.attaqueS(pj1, jLabel5);
                jComboBox2.setEnabled(false);
                jComboBox1.setEnabled(true);
                //jLabel5.setText(pj2.nom + " utilise l'Attaque Spéciale : " + pj2.nomAttaqueS );
            }else{
                jLabel5.setText("Cette attaque n'est pas encore chargée");
            }
            
        }else if(selectedAttack == "Soin"){
            Personnage temp2 = new Personnage(pj2.element);
            if(charge2 >= 2){
                charge2 -= 2;
                jProgressBar3.setValue(charge2*20);
                if(pj2.limAtt3%3 != 0 ) pj2.limAtt3++;
                if(pj1.limAtt3%3 == 0 ) att3pret1 = true;
                pj2.vie += pj2.soin;
                if (pj2.vie > temp2.vie) pj2.vie = temp2.vie;
                jComboBox2.setEnabled(false);
                jComboBox1.setEnabled(true);
                jLabel5.setText(pj2.nom + " utilise Soin (+ " + pj2.soin + " points de vie)");
            }else{
                jLabel5.setText("Soin n'est pas encore chargé");
            }
        
        }else if(selectedAttack == "Switch"){
        
            sw = 2;
            
            panGame.setVisible(false);
            panChoix.setVisible(true);
            
            comb1j1.setEnabled(false);
            comb2j1.setEnabled(false);
            comb3j1.setEnabled(false);
            
            if(b1j2) comb1j2.setEnabled(true);
            if(b2j2) comb2j2.setEnabled(true);
            if(b3j2) comb3j2.setEnabled(true);
            
            premierClick1 = 0;
            premierClick2 = 0;
            premierClick3 = 0;
            premierClick4 = 0;
            premierClick5 = 0;
            premierClick6 = 0;
            comb1j2.setBorder(noborder);
            comb2j2.setBorder(noborder);
            comb3j2.setBorder(noborder);
            startPanChoix.setEnabled(false);
            pret1 = true;
            pret2 = false;
            
            
            
        }
        
        Personnage temp1 = new Personnage(pj1.element);
        Personnage temp2 = new Personnage(pj2.element);
        jProgressBar1.setValue((int)(pj1.vie/temp1.vie*100));
        jProgressBar2.setValue((int)(pj2.vie/temp2.vie*100));
        if(pj1.vie<=0){
            kill_2++;
            if(kill_2 == 3){
                panGame.setVisible(false);
                panFin.setVisible(true);
                nomGagnant.setText(nameJ2);
                
                music musicObject = new music();
                musicObject.playMusic("yay.wav");
            }else{
                panGame.setVisible(false);
                panChoix.setVisible(true);
                sw = 0;
                switch (a){
                    case 1:
                        comb1j1.setEnabled(false);
                        b1j1 = false; 
                        break;
                    case 2:
                        comb2j1.setEnabled(false);
                        b2j1 = false; 
                        break;
                    case 3:
                        comb3j1.setEnabled(false);
                        b3j1 = false; 
                        break;
                }
                
                comb1j2.setEnabled(false);
                comb2j2.setEnabled(false);
                comb3j2.setEnabled(false);
                
                j2perd = false;
                j1perd = true;
                
                premierClick1 = 0;
                premierClick2 = 0;
                premierClick3 = 0;
                premierClick4 = 0;
                premierClick5 = 0;
                premierClick6 = 0;
                comb1j1.setBorder(noborder);
                comb2j1.setBorder(noborder);
                comb3j1.setBorder(noborder);
                startPanChoix.setEnabled(false);
                pret1 = false;
                pret2 = true;
                actif1 = false;
                active1 = false;
                att3pret1 = false;
                charge1 = 0;
                jProgressBar4.setValue(0);
            }
        }
        if((int)(pj1.vie/temp1.vie*100)<=15 && actif1 == false && !active1){
            powUp1.setVisible(true);
        }
        if((int)(pj2.vie/temp2.vie*100)<=15 && actif2 == false){
            powUp2.setEnabled(false);
        }
        
                if(!b1j2) comb1j2.setBorder(deadborder);
                if(!b2j2) comb2j2.setBorder(deadborder);
                if(!b3j2) comb3j2.setBorder(deadborder);
                if(!b1j1) comb1j1.setBorder(deadborder);
                if(!b2j1) comb2j1.setBorder(deadborder);
                if(!b3j1) comb3j1.setBorder(deadborder);
                if(b1j1 && sw==0) comb1j1.setEnabled(true);
                if(b2j1 && sw==0) comb2j1.setEnabled(true);
                if(b3j1 && sw==0) comb3j1.setEnabled(true);
        tour = 1;
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int rate = (int)(Math.random()*10);
        
        selectedAttack = jComboBox1.getSelectedItem().toString();
        sw=0;
        
        if(selectedAttack == "Charger"){
            
            if(charge1 == 5){
                jLabel4.setText("L'attaque spéciale est déjà chargée");
            }else{
                charge1++;
                jProgressBar4.setValue(charge1*20);
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(true);
                if(pj2.limAtt3%3 == 0 ) att3pret2 = true;
                jLabel4.setText(pj1.nom + " choisit de charger");
            }
            
        }else if(selectedAttack == "Attaque 1"){
            
            if(rate == 9){
                if(pj1.limAtt3%3 != 0 ) pj1.limAtt3++;
                if(pj2.limAtt3%3 == 0 ) att3pret2 = true;
                jLabel4.setText(pj1.nom + " rate sa cible");
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(true);
            }else{
                if(pj1.limAtt3%3 != 0 ) pj1.limAtt3++;
                if(pj2.limAtt3%3 == 0 ) att3pret2 = true;
                pj2.vie -= pj1.att1;
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(true);
                jLabel4.setText(pj1.nom + " utilise Attaque 1 : " + pj1.nomAttaque1 + " qui est une attaque physique");
            }
            
        }else if(selectedAttack == "Attaque 2"){
            
            if(rate == 9){
                if(pj1.limAtt3%3 != 0 ) pj1.limAtt3++;
                if(pj2.limAtt3%3 == 0 ) att3pret2 = true;
                jLabel4.setText(pj1.nom + " rate sa cible");
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(true);
            }else{
                if(pj1.limAtt3%3 != 0 ) pj1.limAtt3++;
                if(pj2.limAtt3%3 == 0 ) att3pret2 = true;
                pj2.vie -= pj1.att2;
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(true);
                jLabel4.setText(pj1.nom + " utilise Attaque 2 : " + pj1.nomAttaque2 + " qui est une attaque " + pj1.nomElement);
            }
            
        }else if(selectedAttack == "Attaque 3"){
            
            if(att3pret1){
                
                if(rate == 9){
                    pj1.limAtt3++;
                    jLabel4.setText(pj1.nom + " rate sa cible");
                    if(pj2.limAtt3%3 == 0 ) att3pret2 = true;
                    jComboBox1.setEnabled(false);
                    jComboBox2.setEnabled(true);
                    att3pret1 = false;
                }else{
                    pj1.limAtt3++;
                    pj2.vie -= pj1.att3;
                    if(pj2.limAtt3%3 == 0 ) att3pret2 = true;
                    jComboBox1.setEnabled(false);
                    jComboBox2.setEnabled(true);
                    att3pret1 = false;
                    jLabel4.setText(pj1.nom + "u tilise Attaque 3 : " + pj1.nomAttaque3 + " qui est une attaque " + pj1.nomElement);
                }
                
            }else{
                jLabel4.setText("attendez encore "+ (3-(pj1.limAtt3%3)) +" tour(s) avant d'utiliser cette attaque");
            }
        }else if(selectedAttack == "Attaque S"){
        
            if(charge1 == 5){
                charge1 = 0;
                jProgressBar4.setValue(0);
                if(pj1.limAtt3%3 != 0 ) pj1.limAtt3++;
                if(pj2.limAtt3%3 == 0 ) att3pret2 = true;
                pj1.attaqueS(pj2, jLabel4);
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(true);
                //jLabel4.setText(pj1.nom + " utilise l'Attaque Spéciale : " + pj1.nomAttaqueS );
            }else{
                jLabel4.setText("Cette attaque n'est pas encore chargée");
            }
            
        }else if(selectedAttack == "Soin"){
            Personnage temp1 = new Personnage(pj1.element);
            if(charge1 >= 2){
                charge1 -= 2;
                jProgressBar4.setValue(charge1*20);
                if(pj1.limAtt3%3 != 0 ) pj1.limAtt3++;
                if(pj2.limAtt3%3 == 0 ) att3pret2= true;
                pj1.vie += pj1.soin;
                if (pj1.vie > temp1.vie) pj1.vie = temp1.vie;
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(true);
                jLabel4.setText(pj1.nom + " utilise Soin (+ " + pj1.soin + " points de vie)");
            }else{
                jLabel4.setText("Soin n'est pas encore chargé");
            }
        
        }else if(selectedAttack == "Switch"){
        
            sw = 1;
            
            panGame.setVisible(false);
            panChoix.setVisible(true);
            
            comb1j2.setEnabled(false);
            comb2j2.setEnabled(false);
            comb3j2.setEnabled(false);
            
            if(b1j1) comb1j1.setEnabled(true);
            if(b2j1) comb2j1.setEnabled(true);
            if(b3j1) comb3j1.setEnabled(true);
            
            premierClick1 = 0;
            premierClick2 = 0;
            premierClick3 = 0;
            premierClick4 = 0;
            premierClick5 = 0;
            premierClick6 = 0;
            comb1j1.setBorder(noborder);
            comb2j1.setBorder(noborder);
            comb3j1.setBorder(noborder);
            startPanChoix.setEnabled(false);
            pret1 = false;
            pret2 = true;
            
        }
        
        Personnage temp1 = new Personnage(pj1.element);
        Personnage temp2 = new Personnage(pj2.element);
        jProgressBar2.setValue((int)(pj2.vie/temp2.vie*100));
        jProgressBar1.setValue((int)(pj1.vie/temp1.vie*100));
        if(pj2.vie<=0){
            kill_1++;
            if(kill_1 == 3){
                panGame.setVisible(false);
                panFin.setVisible(true);
                nomGagnant.setText(nameJ1);
                
                
                music musicObject = new music();
                musicObject.playMusic("yay.wav");
                
                
            }else{
                panGame.setVisible(false);
                panChoix.setVisible(true);
                sw = 0;
                switch (b){
                    case 1:
                        comb1j2.setEnabled(false);
                        b1j2 = false; 
                        break;
                    case 2:
                        comb2j2.setEnabled(false);
                        b2j2 = false; 
                        break;
                    case 3:
                        comb3j2.setEnabled(false);
                        b3j2 = false; 
                        break;
                }
                
                comb1j1.setEnabled(false);
                comb2j1.setEnabled(false);
                comb3j1.setEnabled(false);
                
                j1perd = false;
                j2perd = true;
                
                premierClick1 = 0;
                premierClick2 = 0;
                premierClick3 = 0;
                premierClick4 = 0;
                premierClick5 = 0;
                premierClick6 = 0;
                comb1j2.setBorder(noborder);
                comb2j2.setBorder(noborder);
                comb3j2.setBorder(noborder);
                startPanChoix.setEnabled(false);
                pret1 = true;
                pret2 = false;
                actif2 = false;
                active2 = false;
                att3pret2 = false;
                charge2 = 0;
                jProgressBar3.setValue(0);
            }
        }
        
        if((int)(pj2.vie/temp2.vie*100)<=15 && actif2 == false && !active2){
            powUp2.setVisible(true);
        }
        if((int)(pj1.vie/temp1.vie*100)<=15 && actif1 == false){
            powUp1.setEnabled(false);
        }
        
                if(!b1j2) comb1j2.setBorder(deadborder);
                if(!b2j2) comb2j2.setBorder(deadborder);
                if(!b3j2) comb3j2.setBorder(deadborder);
                if(!b1j1) comb1j1.setBorder(deadborder);
                if(!b2j1) comb2j1.setBorder(deadborder);
                if(!b3j1) comb3j1.setBorder(deadborder);
                if(b1j2 && sw==0) comb1j2.setEnabled(true);
                if(b2j2 && sw==0) comb2j2.setEnabled(true);
                if(b3j2 && sw==0) comb3j2.setEnabled(true);
        tour = 2;
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // cette méthode fait fonctionner le dépliage des différentes attaques lors des règles du jeu
        selectedAttack = jComboBox3.getSelectedItem().toString();
        
        if(selectedAttack == "Charger"){
        
            jLabel30.setIcon(charger);
            

        }else if(selectedAttack == "Attaque 1"){
            jLabel30.setIcon(att1);
            
        }else if(selectedAttack == "Attaque 2"){
            jLabel30.setIcon(att2);
            
        }else if(selectedAttack == "Attaque 3"){
            jLabel30.setIcon(att3);
            
        }else if(selectedAttack == "Attaque S"){
        
            jLabel30.setIcon(attS);
            
        }else if(selectedAttack == "Soin"){
            
            jLabel30.setIcon(soin);
            
        }else if(selectedAttack == "Switch"){
        
            jLabel30.setIcon(switcher);
            
        }else if(selectedAttack == "Activer domaine"){
        
            jLabel30.setIcon(domaine);
            
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        panChoixI.setVisible(true);
        panRegles2.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        panRegles2.setVisible(true);
        jButton3.setVisible(true);
        jButton4.setVisible(false);
        jComboBox3.setVisible(true);
        panRegles.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField137ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField137ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField137ActionPerformed

    private void jTextField141ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField141ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField141ActionPerformed

    private void jTextField145ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField145ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField145ActionPerformed

    private void jTextField149ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField149ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField149ActionPerformed

    private void jTextField153ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField153ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField153ActionPerformed

    private void jTextField157ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField157ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField157ActionPerformed

    private void jTextField161ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField161ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField161ActionPerformed

    private void jTextField165ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField165ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField165ActionPerformed

    private void jTextField169ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField169ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField169ActionPerformed

    private void jTextField173ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField173ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField173ActionPerformed

    private void jTextField177ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField177ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField177ActionPerformed

    private void jTextField181ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField181ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField181ActionPerformed

    private void jTextField185ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField185ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField185ActionPerformed

    private void jTextField189ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField189ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField189ActionPerformed

    private void jTextField193ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField193ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField193ActionPerformed

    private void jTextField197ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField197ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField197ActionPerformed

    private void jTextField201ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField201ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField201ActionPerformed

    private void jTextField205ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField205ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField205ActionPerformed

    private void jTextField209ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField209ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField209ActionPerformed

    private void jTextField213ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField213ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField213ActionPerformed

    private void jTextField217ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField217ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField217ActionPerformed

    private void jTextField221ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField221ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField221ActionPerformed

    private void jTextField225ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField225ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField225ActionPerformed

    private void jTextField229ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField229ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField229ActionPerformed

    private void jTextField233ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField233ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField233ActionPerformed

    private void jTextField237ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField237ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField237ActionPerformed

    private void jTextField241ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField241ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField241ActionPerformed

    private void jTextField245ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField245ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField245ActionPerformed

    private void jTextField249ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField249ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField249ActionPerformed

    private void jTextField253ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField253ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField253ActionPerformed

    private void jTextField257ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField257ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField257ActionPerformed

    private void jTextField261ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField261ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField261ActionPerformed

    private void jTextField265ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField265ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField265ActionPerformed

    private void jTextField269ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField269ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField269ActionPerformed

    private void ALEXANDRE_LE_GRANDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ALEXANDRE_LE_GRANDMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(true);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_ALEXANDRE_LE_GRANDMouseClicked

    private void ADAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADAMMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(true);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_ADAMMouseClicked

    private void TOPHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TOPHMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(true);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_TOPHMouseClicked

    private void SALAMECHEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SALAMECHEMouseClicked

        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(true);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_SALAMECHEMouseClicked

    private void CARAPUCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CARAPUCEMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(true);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_CARAPUCEMouseClicked

    private void VEGETAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VEGETAMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(true);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_VEGETAMouseClicked

    private void PIKACHUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PIKACHUMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(true);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_PIKACHUMouseClicked

    private void KIMIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KIMIMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(true);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_KIMIMouseClicked

    private void QUENTINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QUENTINMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(true);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_QUENTINMouseClicked

    private void MBAPPEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MBAPPEMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(true);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_MBAPPEMouseClicked

    private void MICHAEL_JACKSONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MICHAEL_JACKSONMouseClicked
        Michael.setVisible(true);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_MICHAEL_JACKSONMouseClicked

    private void THOMAS_PESQUETMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_THOMAS_PESQUETMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(true);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_THOMAS_PESQUETMouseClicked

    private void GAIAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GAIAMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(true);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_GAIAMouseClicked

    private void HADESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HADESMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(true);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_HADESMouseClicked

    private void POSEIDONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POSEIDONMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(true);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_POSEIDONMouseClicked

    private void ACTEONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACTEONMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(true);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_ACTEONMouseClicked

    private void ZEUSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ZEUSMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(true);
        Chione.setVisible(false);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_ZEUSMouseClicked

    private void CHIONEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CHIONEMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(true);
        Chronos.setVisible(false);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_CHIONEMouseClicked

    private void CRONOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CRONOSMouseClicked
        Michael.setVisible(false);
        Toph.setVisible(false);
        Carapuce.setVisible(false);
        Salameche.setVisible(false);
        Vegeta.setVisible(false);
        Pikachu.setVisible(false);
        Kimi.setVisible(false);
        Alex.setVisible(false);
        Adam.setVisible(false);
        Quentin.setVisible(false);
        Mbappe.setVisible(false);
        Pesquet.setVisible(false);
        GAÏA.setVisible(false);
        Hades.setVisible(false);
        Poseidon.setVisible(false);
        Acteon.setVisible(false);
        Zeus.setVisible(false);
        Chione.setVisible(false);
        Chronos.setVisible(true);
        panHome.setVisible(false);
        panFin.setVisible(false);
        panPersos.setVisible(false);
        panOptions.setVisible(false);
        panAPropos.setVisible(false);
        panGame.setVisible(false);
        panChoix.setVisible(false);
        panChoixI.setVisible(false);
        panRegles.setVisible(false);
        panRegles2.setVisible(false);
        jp2.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_CRONOSMouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField211ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField211ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField211ActionPerformed

    private void jTextField228ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField228ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField228ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Game g = new Game();
        g.setIconImage(ImageIO.read(new File("icone.png")));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                g.setVisible(true);        

            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACTEON;
    private javax.swing.JLabel ADAM;
    private javax.swing.JLabel ALEXANDRE_LE_GRAND;
    private javax.swing.JLabel A_PROPOS;
    private javax.swing.JPanel Acteon;
    private javax.swing.JPanel Adam;
    private javax.swing.JPanel Alex;
    private javax.swing.JLabel CARAPUCE;
    private javax.swing.JLabel CHIONE;
    private javax.swing.JLabel CRONOS;
    private javax.swing.JPanel Carapuce;
    private javax.swing.JPanel Chione;
    private javax.swing.JPanel Chronos;
    private javax.swing.JLabel GAIA;
    private javax.swing.JPanel GAÏA;
    private javax.swing.JLabel HADES;
    private javax.swing.JPanel Hades;
    private javax.swing.JLabel KIMI;
    private javax.swing.JPanel Kimi;
    private javax.swing.JLabel MARCHALOT;
    private javax.swing.JLabel MBAPPE;
    private javax.swing.JLabel MICHAEL_JACKSON;
    private javax.swing.JPanel Mbappe;
    private javax.swing.JPanel Michael;
    private javax.swing.JLabel PIKACHU;
    private javax.swing.JLabel POSEIDON;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Pesquet;
    private javax.swing.JPanel Pikachu;
    private javax.swing.JPanel Poseidon;
    private javax.swing.JLabel QUENTIN;
    private javax.swing.JPanel Quentin;
    private javax.swing.JLabel SALAMECHE;
    private javax.swing.JPanel Salameche;
    private javax.swing.JLabel THOMAS_PESQUET;
    private javax.swing.JLabel TOPH;
    private javax.swing.JPanel Toph;
    private javax.swing.JLabel VEGETA;
    private javax.swing.JPanel Vegeta;
    private javax.swing.JLabel ZEUS;
    private javax.swing.JPanel Zeus;
    private javax.swing.JMenuBar barreDeMenu;
    private javax.swing.JLabel comb1j1;
    private javax.swing.JLabel comb1j2;
    private javax.swing.JLabel comb2j1;
    private javax.swing.JLabel comb2j2;
    private javax.swing.JLabel comb3j1;
    private javax.swing.JLabel comb3j2;
    private javax.swing.JButton combattre;
    private javax.swing.JButton eau;
    private javax.swing.JLabel eauTof;
    private javax.swing.JButton feu;
    private javax.swing.JLabel feuTof;
    private javax.swing.JButton foudre;
    private javax.swing.JLabel foudreTof;
    private javax.swing.JButton glace;
    private javax.swing.JLabel glaceTof;
    private javax.swing.JLabel insa;
    private javax.swing.JLabel instructionsChoixI1;
    private javax.swing.JLabel instructionsChoixI2;
    private javax.swing.JLabel instructionsChoixI3;
    private javax.swing.JLabel instructionsChoixI4;
    private javax.swing.JLabel j1;
    private javax.swing.JLabel j2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel308;
    private javax.swing.JLabel jLabel309;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel310;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField137;
    private javax.swing.JTextField jTextField138;
    private javax.swing.JTextField jTextField139;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField140;
    private javax.swing.JTextField jTextField141;
    private javax.swing.JTextField jTextField142;
    private javax.swing.JTextField jTextField143;
    private javax.swing.JTextField jTextField144;
    private javax.swing.JTextField jTextField145;
    private javax.swing.JTextField jTextField146;
    private javax.swing.JTextField jTextField147;
    private javax.swing.JTextField jTextField148;
    private javax.swing.JTextField jTextField149;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField150;
    private javax.swing.JTextField jTextField151;
    private javax.swing.JTextField jTextField152;
    private javax.swing.JTextField jTextField153;
    private javax.swing.JTextField jTextField154;
    private javax.swing.JTextField jTextField155;
    private javax.swing.JTextField jTextField156;
    private javax.swing.JTextField jTextField157;
    private javax.swing.JTextField jTextField158;
    private javax.swing.JTextField jTextField159;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField160;
    private javax.swing.JTextField jTextField161;
    private javax.swing.JTextField jTextField162;
    private javax.swing.JTextField jTextField163;
    private javax.swing.JTextField jTextField164;
    private javax.swing.JTextField jTextField165;
    private javax.swing.JTextField jTextField166;
    private javax.swing.JTextField jTextField167;
    private javax.swing.JTextField jTextField168;
    private javax.swing.JTextField jTextField169;
    private javax.swing.JTextField jTextField170;
    private javax.swing.JTextField jTextField171;
    private javax.swing.JTextField jTextField172;
    private javax.swing.JTextField jTextField173;
    private javax.swing.JTextField jTextField174;
    private javax.swing.JTextField jTextField175;
    private javax.swing.JTextField jTextField176;
    private javax.swing.JTextField jTextField177;
    private javax.swing.JTextField jTextField178;
    private javax.swing.JTextField jTextField179;
    private javax.swing.JTextField jTextField180;
    private javax.swing.JTextField jTextField181;
    private javax.swing.JTextField jTextField182;
    private javax.swing.JTextField jTextField183;
    private javax.swing.JTextField jTextField184;
    private javax.swing.JTextField jTextField185;
    private javax.swing.JTextField jTextField186;
    private javax.swing.JTextField jTextField187;
    private javax.swing.JTextField jTextField188;
    private javax.swing.JTextField jTextField189;
    private javax.swing.JTextField jTextField190;
    private javax.swing.JTextField jTextField191;
    private javax.swing.JTextField jTextField192;
    private javax.swing.JTextField jTextField193;
    private javax.swing.JTextField jTextField194;
    private javax.swing.JTextField jTextField195;
    private javax.swing.JTextField jTextField196;
    private javax.swing.JTextField jTextField197;
    private javax.swing.JTextField jTextField198;
    private javax.swing.JTextField jTextField199;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField200;
    private javax.swing.JTextField jTextField201;
    private javax.swing.JTextField jTextField202;
    private javax.swing.JTextField jTextField203;
    private javax.swing.JTextField jTextField204;
    private javax.swing.JTextField jTextField205;
    private javax.swing.JTextField jTextField206;
    private javax.swing.JTextField jTextField207;
    private javax.swing.JTextField jTextField208;
    private javax.swing.JTextField jTextField209;
    private javax.swing.JTextField jTextField210;
    private javax.swing.JTextField jTextField211;
    private javax.swing.JTextField jTextField212;
    private javax.swing.JTextField jTextField213;
    private javax.swing.JTextField jTextField214;
    private javax.swing.JTextField jTextField215;
    private javax.swing.JTextField jTextField216;
    private javax.swing.JTextField jTextField217;
    private javax.swing.JTextField jTextField218;
    private javax.swing.JTextField jTextField219;
    private javax.swing.JTextField jTextField220;
    private javax.swing.JTextField jTextField221;
    private javax.swing.JTextField jTextField222;
    private javax.swing.JTextField jTextField223;
    private javax.swing.JTextField jTextField224;
    private javax.swing.JTextField jTextField225;
    private javax.swing.JTextField jTextField226;
    private javax.swing.JTextField jTextField227;
    private javax.swing.JTextField jTextField228;
    private javax.swing.JTextField jTextField229;
    private javax.swing.JTextField jTextField230;
    private javax.swing.JTextField jTextField231;
    private javax.swing.JTextField jTextField232;
    private javax.swing.JTextField jTextField233;
    private javax.swing.JTextField jTextField234;
    private javax.swing.JTextField jTextField235;
    private javax.swing.JTextField jTextField236;
    private javax.swing.JTextField jTextField237;
    private javax.swing.JTextField jTextField238;
    private javax.swing.JTextField jTextField239;
    private javax.swing.JTextField jTextField240;
    private javax.swing.JTextField jTextField241;
    private javax.swing.JTextField jTextField242;
    private javax.swing.JTextField jTextField243;
    private javax.swing.JTextField jTextField244;
    private javax.swing.JTextField jTextField245;
    private javax.swing.JTextField jTextField246;
    private javax.swing.JTextField jTextField247;
    private javax.swing.JTextField jTextField248;
    private javax.swing.JTextField jTextField249;
    private javax.swing.JTextField jTextField250;
    private javax.swing.JTextField jTextField251;
    private javax.swing.JTextField jTextField252;
    private javax.swing.JTextField jTextField253;
    private javax.swing.JTextField jTextField254;
    private javax.swing.JTextField jTextField255;
    private javax.swing.JTextField jTextField256;
    private javax.swing.JTextField jTextField257;
    private javax.swing.JTextField jTextField258;
    private javax.swing.JTextField jTextField259;
    private javax.swing.JTextField jTextField260;
    private javax.swing.JTextField jTextField261;
    private javax.swing.JTextField jTextField262;
    private javax.swing.JTextField jTextField263;
    private javax.swing.JTextField jTextField264;
    private javax.swing.JTextField jTextField265;
    private javax.swing.JTextField jTextField266;
    private javax.swing.JTextField jTextField267;
    private javax.swing.JTextField jTextField268;
    private javax.swing.JTextField jTextField269;
    private javax.swing.JTextField jTextField270;
    private javax.swing.JTextField jTextField271;
    private javax.swing.JTextField jTextField272;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField joueur1Name;
    private javax.swing.JButton joueur1OK;
    private javax.swing.JTextField joueur2Name;
    private javax.swing.JButton joueur2OK;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JPanel jp4;
    private javax.swing.JLabel logo;
    private javax.swing.JMenu menuGame;
    private javax.swing.JMenu menuSettings;
    private javax.swing.JButton nature;
    private javax.swing.JLabel natureTof;
    private javax.swing.JLabel nomGagnant;
    private javax.swing.JToggleButton nombreJoueurs;
    private javax.swing.JPanel panAPropos;
    private javax.swing.JPanel panChoix;
    private javax.swing.JPanel panChoixI;
    private javax.swing.JPanel panFin;
    private javax.swing.JPanel panGame;
    private javax.swing.JLabel panGameImage;
    private javax.swing.JPanel panHome;
    private javax.swing.JPanel panOptions;
    private javax.swing.JPanel panPersos;
    private javax.swing.JPanel panRegles;
    private javax.swing.JPanel panRegles2;
    private javax.swing.JLabel persoLabel;
    private javax.swing.JLabel persoLabel1;
    private javax.swing.JLabel persoLabel2;
    private javax.swing.JLabel persoLabel3;
    private javax.swing.JToggleButton powUp1;
    private javax.swing.JToggleButton powUp2;
    private javax.swing.JLabel qstNbJoueurs;
    private javax.swing.JLabel regles1;
    private javax.swing.JLabel regles10;
    private javax.swing.JButton startGame;
    private javax.swing.JToggleButton startPanChoix;
    private javax.swing.JButton terre;
    private javax.swing.JLabel terreTof;
    private javax.swing.JLabel vsImage;
    // End of variables declaration//GEN-END:variables
}