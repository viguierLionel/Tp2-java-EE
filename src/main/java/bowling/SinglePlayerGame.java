package bowling;
import java.util.ArrayList;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
        
	/**
	 * Constructeur
	 */
         
         int score[] = new int[22];
         //for(int i =0; i<22 ; i++){score[i] = 42; }
         int numeroLancer = 0 ;
         
         
	public SinglePlayerGame() {
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            score[numeroLancer] = nombreDeQuillesAbattues;
            numeroLancer ++;
            if(nombreDeQuillesAbattues == 10 && numeroLancer <= 19){
            score[numeroLancer] = -1;
            numeroLancer ++;}
            
            
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            int res = 0;
            boolean secondeBoule = false;
            for(int i =0 ; i < 20 ; i++){
                System.out.println(score[i]);
                if (score[i] == 10 && !(secondeBoule)){if(score[i+3] == -1){res+=score[i]+score[i+2]+score[i+4];} else{res+=score[i]+score[i+2]+score[i+3];}
                }
                else{
                    if(secondeBoule && score[i]+score[i-1]==10){
                        res+=score[i]+score[i+1];
                        secondeBoule = false;
                    }
                    else{
                        if(score[i]!= -1){res+=score[i];secondeBoule = !(secondeBoule);}
                        
                    }
                }
            }
                return res;
	}
}
