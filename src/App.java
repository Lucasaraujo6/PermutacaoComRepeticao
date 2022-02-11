import java.util.Scanner;

public class App 
{
    static int valorMax, qntdColunas, qntdLinhas, colUltimaAlteracao;
    static int[][] valores;

    public static void main(String[] args) throws Exception 
    {
        getValues();
        setValues();
        fillVector();
        imprimir();
    }

    private static void imprimir() 
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
        qntdLinhas = (int) Math.pow(valorMax, qntdColunas);
        colUltimaAlteracao = qntdColunas - 1;
        valores = new int[qntdLinhas][qntdColunas];
    }

    private static void getValues() 
    {
        Scanner scan = new Scanner(System.in);
        do 
        {
            try 
            {
                System.out.println("Digite, respectivamente, os valores de r e n:");
                qntdColunas = scan.nextInt();
                valorMax = scan.nextInt();
                
            } catch (Exception e) 
            {
                System.out.println("Valores inválidos!");
                scan.nextLine();
            }
        } while (2 > qntdColunas || qntdColunas > 10 || valorMax > 20 || 1 > valorMax);

        scan.close();
    }
}
