import java.util.Scanner;

public class App 
{
    static int valorMax, qntdColunas, qntdLinhas, colUltimaAlteracao;
    static int[][] valores;

    public static void main(String[] args) throws Exception 
    {
        setValues();
        fillVector();
        print();
    }

    private static void print() 
    {
        for (int i = 0; i < qntdLinhas; i++) 
        {
            for (int j = 0; j < qntdColunas; j++) 
            {
                System.out.print(valores[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    private static void fillVector() 
    {
        // primeira linha
        for (int i = 0; i < qntdColunas; i++) 
        {
            valores[0][i] = 1;
        }
        // demais linhas
        for (int i = 1; i < qntdLinhas; i++) 
        {
            for (int k = 0; k < qntdColunas; k++) 
            {
                valores[i][k] = valores[i - 1][k];
            }
            for (int j = qntdColunas - 1; j > -1; j--) 
            {
                if (valores[i - 1][j] < valorMax) 
                {
                    if (j < colUltimaAlteracao) 
                    {
                        for (int k = j; k < qntdColunas; k++) 
                        {
                            valores[i][k] = 1;
                        }
                    }
                    colUltimaAlteracao = j;
                    valores[i][j] = valores[i - 1][j] + 1;
                    break;
                }
            }
        }
    }

    private static void setValues() 
    {
        Scanner scan = new Scanner(System.in);
        do 
        {
            try 
            {
                System.out.println("Digite, respectivamente, separados por espaço, os valores de r e n:");
                
                qntdColunas = scan.nextInt();
                valorMax = scan.nextInt();
                if(2 > qntdColunas){
                    System.out.println("O o valor de r deve ser maior ou igual a 2.");
                }
                if(qntdColunas > 10){
                    System.out.println("O o valor de r deve ser menor ou igual a 10.");
                }
                if(valorMax > 20){
                    System.out.println("O o valor de n deve ser menor ou igual a 20.");
                }
                if(1 > valorMax){
                    System.out.println("O o valor de r deve ser maior ou igual a 1.");
                }
            } catch (Exception e) 
            {
                System.out.println("Você inseriu um valor inválido. Tente novamente.");
                scan.nextLine();
            }
        } while (2 > qntdColunas || qntdColunas > 10 || valorMax > 20 || 1 > valorMax);

        scan.close();
        qntdLinhas = (int) Math.pow(valorMax, qntdColunas);
        colUltimaAlteracao = qntdColunas - 1;
        valores = new int[qntdLinhas][qntdColunas];
    }

}
