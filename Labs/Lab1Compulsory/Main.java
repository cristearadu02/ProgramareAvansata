public class Main {
    public static void main(String[] args) throws Exception
    {
        System.out.println("Hello world!");

        String[] languages = new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        n = n*3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n*6;
        int sum = 0;
        //test

        while(n!=0)
        {
            sum = sum + n % 10;
            n= n / 10;
        }

        while(sum>=10)
        {
            n = sum;
            sum = 0;
            while(n!=0)
            {
                sum = sum + n % 10;
                n= n / 10;
            }
        }

        String output = "Willy-nilly, this semester I will learn ";
        output = output + languages[sum];
        System.out.println(sum);
        System.out.println(output);
    }
}