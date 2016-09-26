using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace ConsoleApplication1
{
    class Program
    {

        //Initialise variables, lists and Queues

        private List<string> txtlist = new List<string>();
        private string txt = "";
        private List<string> final = new List<string>();
        private Queue<char> four = new Queue<char>();
        
        
        //Call all methods as well as read files and get user input
        static void Main(string[] args)
        {
            string path = @"";
            Console.WriteLine("Please enter a word: ");
            string word = Console.ReadLine();
            Console.WriteLine("Now please enter the full file path of your dictionary file.");
             path += Console.ReadLine();

            var toDict  = System.IO.File.ReadAllLines(path);
            List<string> dict = new List<string>(toDict);

            Program play = new Program(word, dict);
        }


        //Create instance of Program
        public Program(string word, List<string> dict)
        {
            split(word);
            comp(dict);
            Console.WriteLine(txtlist.Count);

            final.ForEach(i => Console.WriteLine("{0}",i));
            Console.WriteLine(final.Count);
            Console.WriteLine("Press a key to escape");
            Console.ReadKey();
        }


        //Comparing the results from split with a specified dictionary
        public List<string> comp(List<string> dict)
        {
            foreach(string s in txtlist)
            {
                foreach(string d in dict)
                {
                    if (d.ToLower().Contains(s.ToLower()))
                    {
                        final.Add(d);
                    }
                }
            }
            final = final.Distinct().ToList();
            final.Sort();
            return final;
        }


        //Splitting the word into substrings of length 4
        public void split(string src)
        {
            foreach(char l in src)
            {
                four.Enqueue(l);
                if(four.Count() < 4)
                {
                    continue;
                }else
                {
                    foreach(char k in four)
                    {
                        txt += k;
                    }
                    Console.WriteLine(txt);
                    txtlist.Add(txt);
                    txt = "";
                    four.Dequeue();
                   

                }
            }
        }

    }
}
