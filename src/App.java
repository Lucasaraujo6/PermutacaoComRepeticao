import java.util.Scanner;

import javax.swing.plaf.synth.ColorType;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int valorMax = scan.nextInt();
        int qntdColunas = scan.nextInt();
        int qntdLinhas = (int) Math.pow(valorMax, qntdColunas);
        int colUltimaAlteracao = qntdColunas-1;
        // System.out.println("qntd linhas"+qntdLinhas);
        int[][] valores = new int[qntdLinhas][qntdColunas];

        // Define o primeiro termo 1111111
        for (int i = 0; i < qntdColunas; i++) {

            valores[0][i] = 1;
        }
        // System.out.println("valores primeira: ");
        // for (int i=0;i<qntdColunas;i++){
        //     System.out.print(valores[0][i]);
        // }
        // System.out.println("---------------");
        for (int i = 1; i < qntdLinhas; i++) {
            for (int k = 0; k < qntdColunas; k++) {
                valores[i][k] = valores[i - 1][k];
            }
            for (int j = qntdColunas - 1; j > -1; j--) {
            
                if (valores[i - 1][j] < valorMax) {

                    if (j<colUltimaAlteracao){
                        for (int k = j; k < qntdColunas; k++) {
                            valores[i][k] = 1;
                        }
                    }
                    colUltimaAlteracao=j;
                    valores[i][j] = valores[i - 1][j] + 1;
                    break;
                }
            }        
        }
        for (int i = 0; i < qntdLinhas; i++) {

            for (int j = 0; j < qntdColunas; j++) {
                System.out.print(valores[i][j]);
            }
            System.out.println("");

        }

    }
}
