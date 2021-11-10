import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int[] tab;
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Indique o tamanho da tabela (>2).");
        if (sc.hasNextInt()) {//Checks if the input contains anything else than an interger
            n = sc.nextInt();//Input
            if (n <= 2)
                System.out.println("Erro. O número introduzido é <= 2.");//Limits the input to only integers >2
            else {
                tab = new int[n];//Table declared with the length it's given
                insere_tabela(tab, sc);//Fills the table up
                System.out.print("Tabela = {");
                for (int i = 0; i < tab.length; i++) {//For loop to print the table contents
                    if (i != tab.length - 1)
                        System.out.print(tab[i] + ", ");
                    else
                        System.out.println(tab[i] + "}");
                }
                ordem(tab);//Creates a sub-table and prints it
            }
        } else
            System.out.println("Erro. Insira apenas números inteiros maiores que 2.");

    }

    public static void insere_tabela(int[] tabela, Scanner sc) {
        for (int i = 0; i < tabela.length; i++) {
            System.out.println("Indique o número da posição " + (i + 1));
            if (sc.hasNextInt())//If the input is an interger, it adds the number to the table in the right index
                tabela[i] = sc.nextInt();
            else
                System.out.println("Erro. Insira apenas números inteiros.");
        }
    }

    public static void ordem(int[] tabela) {
        int first = 0, last = 0, counter = 0;
        for (int i = 0; i < tabela.length; i++) {//Goes through the table contents and checks if a number is bigger than others
            for (int j = i; j < tabela.length; j++) {
                if (tabela[i] > tabela[j]) {//If the number selected is the first to be bigger than others
                    counter++;              //It saves the number
                    if (counter == 1)
                        first = i;
                    last = i + 1;//The last number to be bigger than the selected, it saves it
                }
            }
        }
        System.out.print("Sub-tabela:\n{");
        for (int i = first; i <= last; i++) {//Prints out the table starting from the first index that has a number
            if (i != last)                   //Bigger than the others and stops on the last
                System.out.print(tabela[i] + ", ");
            else
                System.out.println(tabela[i] + "}");
        }
    }
}
