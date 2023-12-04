import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Personnage {
    
    String nom;
    String nomElement;
    String nomAttaque1;
    String nomAttaque2;
    String nomAttaque3;
    String nomAttaqueS;
    double vie;
    double att1;
    double att2;
    double att3;
    double attS;
    double soin;
    double vitesse;
    int element;
    int limAtt3;
    ImageIcon photo;
    ImageIcon background;
    
    
    public Personnage(int elementI){
        this.element = elementI;
        this.limAtt3 = 1;
        maj();
    }
    
    private void maj(){
        if(element==1){
            this.nom = "Toph";
            this.nomElement = "Terre";
            this.vie = 2500;
            this.att1 = 250;
            this.att2 = 350;
            this.att3 = 400;
            this.attS = 800;
            this.soin = 300;
            this.nomAttaque1 = "Tremblement de terre";
            this.nomAttaque2 = "Séisme";
            this.nomAttaque3 = "Avalanche de pierres";
            this.vitesse = 4;//sur 10
            this.photo = new ImageIcon("toph.jpg");
            this.background = new ImageIcon("areneTerre.jpg");
        }else if(element==2){
            this.nom = "Salamèche";
            this.nomElement = "Feu";
            this.vie = 2000;
            this.att1 = 200;
            this.att2 = 350;
            this.att3 = 425;
            this.attS = 850;
            this.soin = 425;
            this.nomAttaque1 = "Nitrocharge";
            this.nomAttaque2 = "Lance-flamme";
            this.nomAttaque3 = "Rebondifeu";
            this.vitesse = 6;
            this.photo = new ImageIcon("salameche.jpg");
            this.background = new ImageIcon("areneFeu.jpg");
        }else if(element==3){
            this.nom = "Carapuce";
            this.nomElement = "Eau";
            this.vie = 1850;
            this.att1 = 185;
            this.att2 = 340;
            this.att3 = 480;
            this.attS = 950;
            this.soin = 400;
            this.nomAttaque1 = "Aqua-jet";
            this.nomAttaque2 = "Vibraqua";
            this.nomAttaque3 = "Hydroqueue";
            this.vitesse = 8;
            this.photo = new ImageIcon("carapuce.jpg");
            this.background = new ImageIcon("areneEau.jpg");
        }else if(element==4){
            this.nom = "Vegeta";
            this.nomElement = "Nature";
            this.vie = 1900;
            this.att1 = 190;
            this.att2 = 350;
            this.att3 = 445;
            this.attS = 925;
            this.soin = 475;
            this.nomAttaque1 = "Super sayen";
            this.nomAttaque2 = "Ultra instinct";
            this.nomAttaque3 = "Tortue géniale";
            this.vitesse = 7;
            this.photo = new ImageIcon("vegeta.jpg");
            this.background = new ImageIcon("areneNature.jpeg");
        }else if(element==5){
            this.nom = "Pikachu";
            this.nomElement = "Foudre";
            this.vie = 1300;
            this.att1 = 125;
            this.att2 = 225;
            this.att3 = 900;
            this.attS = 1250;
            this.soin = 300;
            this.nomAttaque1 = "Queue de fer";
            this.nomAttaque2 = "Tonner";
            this.nomAttaque3 = "Fatal foudre";
            this.vitesse = 10;
            this.photo = new ImageIcon("pikachu.png");
            this.background = new ImageIcon("areneFoudre.jpg");
        }else if(element==6){
            this.nom = "Kimi";
            this.nomElement = "Glace";
            this.vie = 1500;
            this.att1 = 150;
            this.att2 = 250;
            this.att3 = 600;
            this.attS = 1000;
            this.soin = 350;
            this.nomAttaque1 = "Depassement";
            this.nomAttaque2 = "DRS";
            this.nomAttaque3 = "Champion du monde";
            this.vitesse = 9;
            this.photo = new ImageIcon("kimi.jpg");
            this.background = new ImageIcon("areneGlace.jpg");
        }else if(element==7){
            this.nom = "Marchalot";
            this.nomElement = "Physique";
            this.vie = 3000;
            this.att1 = 300;
            this.att2 = 300;
            this.att3 = 1375;
            this.attS = 2500;
            this.soin = 500;
            this.nomAttaque1 = "Sortez vos doigts";
            this.nomAttaque2 = "J'ai pas mon chargeur";
            this.nomAttaque3 = "Meilleur prof";
            this.vitesse = 6;
            this.photo = new ImageIcon("Marchalot.png");
            this.background = new ImageIcon("BMC.jpg");
        }else if(element==8){
            this.nom = "Alexandre le grand";
            this.nomElement = "Bogoss";
            this.vie = 2800;
            this.att1 = 300;
            this.att2 = 300;
            this.att3 = 1175;
            this.attS = 2300;
            this.soin = 500;
            this.vitesse = 8;
            this.photo = new ImageIcon("alex.jpg");
            this.background = new ImageIcon("eiffel.jpg");//
        }else if(element==9){
            this.nom = "Quentin";
            this.nomElement = "";
            this.vie = 2600;
            this.att1 = 300;
            this.att2 = 300;
            this.att3 = 1275;
            this.attS = 2400;
            this.soin = 500;
            this.vitesse = 7;
            this.photo = new ImageIcon("quentintemp.jpg");
            this.background = new ImageIcon("windows.jpg");
        }else if(element==10){
            this.nom = "Adam l'arabe";
            this.nomElement = "rien";
            this.vie = 2750;
            this.att1 = 300;
            this.att2 = 300;
            this.att3 = 1275;
            this.attS = 2400;
            this.soin = 500;
            this.vitesse = 7;
            this.photo = new ImageIcon("adam.png");
            this.background = new ImageIcon("maroc-sahara.jpeg");
        }else if(element==11){
            this.nom = "Mbappe";
            this.nomElement = "Football";
            this.vie = 3100;
            this.att1 = 300;
            this.att2 = 300;
            this.att3 = 975;
            this.attS = 2100;
            this.soin = 500;
            this.vitesse = 10;
            this.photo = new ImageIcon("mbappe.jpeg");
            this.background = new ImageIcon("eiffel.jpg");//
        }else if(element==12){
            this.nom = "Michael Jackson";
            this.nomElement = "King of Pop";
            this.vie = 3100;
            this.att1 = 300;
            this.att2 = 300;
            this.att3 = 1075;
            this.attS = 2200;
            this.soin = 500;
            this.vitesse = 9;
            this.photo = new ImageIcon("michael.jpg");
            this.background = new ImageIcon("mj_back.jpg");//
        }else if(element==13){
            this.nom = "Thomas Pesquet";
            this.nomElement = "Espace";
            this.vie = 3100;
            this.att1 = 300;
            this.att2 = 300;
            this.att3 = 1275;
            this.attS = 2400;
            this.soin = 500;
            this.vitesse = 7;
            this.photo = new ImageIcon("pesquet.jpg");
            this.background = new ImageIcon("ISS.jpg");
        }else if(element==14){
            this.nom = "Gaïa";
            this.nomElement = "Terre";
            this.vie = 3750;
            this.att1 = 375;
            this.att2 = 525;
            this.att3 = 600;
            this.attS = 1200;
            this.soin = 450;
            this.vitesse = 4;
            this.photo = new ImageIcon("gaïa.jpg");
            this.background = new ImageIcon("areneTerre.jpg");
        }else if(element==15){
            this.nom = "Hades";
            this.nomElement = "Feu";
            this.vie = 3000;
            this.att1 = 300;
            this.att2 = 525;
            this.att3 = 637.5;
            this.attS = 1275;
            this.soin = 637.5;
            this.vitesse = 6;
            this.photo = new ImageIcon("hades.png");
            this.background = new ImageIcon("areneFeu.jpg");
        }else if(element==16){
            this.nom = "Poséidon";
            this.nomElement = "Eau";
            this.vie = 2775;
            this.att1 = 277.5;
            this.att2 = 510;
            this.att3 = 720;
            this.attS = 1425;
            this.soin = 600;
            this.vitesse = 8;
            this.photo = new ImageIcon("poseidon.jpg");
            this.background = new ImageIcon("areneEau.jpg");
        }else if(element==17){
            this.nom = "Actéon";
            this.nomElement = "Nature";
            this.vie = 2850;
            this.att1 = 285;
            this.att2 = 525;
            this.att3 = 667.5;
            this.attS = 1387.5;
            this.soin = 712.5;
            this.vitesse = 7;
            this.photo = new ImageIcon("acteon.jpg");
            this.background = new ImageIcon("areneNature.jpeg");
        }else if(element==18){
            this.nom = "Zeus";
            this.nomElement = "Foudre";
            this.vie = 1950;
            this.att1 = 187.5;
            this.att2 = 337.5;
            this.att3 = 1350;
            this.attS = 1875;
            this.soin = 450;
            this.vitesse = 10;
            this.photo = new ImageIcon("zeus.jpg");
            this.background = new ImageIcon("areneFoudre.jpg");
        }else if(element==19){
            this.nom = "Chioné";
            this.nomElement = "Glace";
            this.vie = 2250;
            this.att1 = 225;
            this.att2 = 375;
            this.att3 = 900;
            this.attS = 1500;
            this.soin = 525;
            this.vitesse = 6;
            this.photo = new ImageIcon("chione.jpg");
            this.background = new ImageIcon("areneGlace.jpg");
        }else if(element==20){
            this.nom = "Chronos";
            this.nomElement = "Temps";
            this.vie = 3900;
            this.att1 = 350;
            this.att2 = 350;
            this.att3 = 1500;
            this.attS = 2600;
            this.soin = 600;
            this.vitesse = 9;
            this.photo = new ImageIcon("cronos.jpg");
            this.background = new ImageIcon("areneTemps.jpg");
        }
    }

    public void majAtt(String e2){ //jouer et soustraire les points de vie
        
        String e1 = this.nomElement;
        
        reinAtt();
        
        if((e1=="Terre" && e2=="Foudre") ||(e1=="Feu" && e2=="Nature") ||(e1=="Feu" && e2=="Glace") ||(e1=="Eau" && e2=="Feu") ||(e1=="Nature" && e2=="Eau") ||(e1=="Foudre" && e2=="Eau")||(e1=="Glace" && e2=="Nature")){
            this.att2*=2;
            this.att3*=2;
            this.attS*=2;
        }else if((e1=="Feu" && e2=="Eau") ||(e1=="Eau" && e2=="Nature") ||(e1=="Eau" && e2=="Foudre") ||(e1=="Nature" && e2=="Feu") ||(e1=="Nature" && e2=="Glace") ||(e1=="Foudre" && e2=="TErre") ||(e1=="Glace" && e2=="Feu")){
            this.att2/=2;
            this.att3/=2;
            this.attS/=2;
        }
           
    }
    
    public void reinAtt(){
        
        Personnage temp = new Personnage(this.element);
        
        this.att2 = temp.att2 ;
        this.att3 = temp.att3 ;
        this.attS = temp.attS ;
        
    }
    
    public void attaqueS(Personnage pjn, JLabel jtext){
    
        pjn.vie -= this.attS;
        
        if(this.element == 4){
        
            jtext.setText("Finaaall..............Flaaaaaaaaaaaash");
            music musicObject = new music();
            musicObject.playMusic("kamehameha.wav");
        
        }else{
        
            
        }
        
    }
    
    public void sound (){
    
        music musicObject = new music();
        
        switch (this.element) {
            case 13 -> musicObject.playMusic("Houston.wav");
            case 4 -> musicObject.playMusic("nature.wav");
            case 1 -> musicObject.playMusic("earth.wav");
            case 2 -> musicObject.playMusic("feu.wav");
            case 3 -> musicObject.playMusic("eau.wav");
            case 5 -> musicObject.playMusic("Foudre.wav");
            case 6 -> musicObject.playMusic("glace.wav");
            case 17 -> musicObject.playMusic("nature.wav");
            case 14 -> musicObject.playMusic("earth.wav");
            case 15 -> musicObject.playMusic("feu.wav");
            case 16 -> musicObject.playMusic("eau.wav");
            case 18 -> musicObject.playMusic("Foudre.wav");
            case 19 -> musicObject.playMusic("glace.wav");
            case 12 -> musicObject.playMusic("michael-jackson_01.wav");
            default -> {
            }
        }
    
    }
    
    public void picture (JLabel j){
    
        String image = "";
        switch (this.element){
        
            case 1 -> image = "tophPowUp.png";
            case 2 -> image = "charizard.png";
            case 3 -> image = "tortank.jpg";
            case 4 -> image = "vegetassj.jpg";
            case 5 -> image = "pikachu.jpg";
            case 6 -> image = "kimiAngry.jpg";
            case 7 -> image = "einstein.jpg";
            case 8 -> image = "alex.jpg";
            case 9 -> image = "quentintemp.jpg";
            case 10 -> image = "adam.png";
            case 11 -> image = "mbappe.jpg";
            case 12 -> image = "michaeljackson.jpg";
            case 13 -> image = "thomas.jpg";
            case 14 -> image = "gaïa.jpg";
            case 15 -> image = "hades.png";
            case 16 -> image = "poseidon.jpg";
            case 17 -> image = "acteon.jpg";
            case 18 -> image = "zeus.jpg";
            case 19 -> image = "chione.jpg";
            case 20 -> image = "cronos.jpg";
            
        
        }
        ImageIcon powUp = new ImageIcon(image);
        j.setIcon(powUp);
    
    }
    
    
}


