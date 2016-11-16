using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PigLatinTranslator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnTranslate_Click(object sender, EventArgs e)
        {
            txtPig.Clear();

            if (txtEnglish.Text != "")
            {
                string english = txtEnglish.Text.Trim();
                string pigLatin = toPigLatin(english);

                string[] engWords = english.Split();
                string[] pigWords = pigLatin.Split();

                // code to preserve case of original English words
                for (int i = 0; i < engWords.Length; i++)
                {
                    if (isUpper(engWords[i][0]) && isLower(engWords[i][1]))
                    {
                        string word = "";
                        word += toUpper(pigWords[i][0]);
                        for (int j = 1; j < pigWords[i].Length; j++)
                            word += toLower(pigWords[i][j]);
                        pigWords[i] = word;
                    }
                    if (isUpper(engWords[i][0]) && isUpper(engWords[i][1]))
                    {
                        string word = "";
                        word += toUpper(pigWords[i][0]);
                        for (int j = 1; j < pigWords[i].Length; j++)
                            word += toUpper(pigWords[i][j]);
                        pigWords[i] = word;
                    }
                }

                foreach (string s in pigWords)
                    txtPig.Text += s + " ";
            }
            else
            {
                MessageBox.Show("You must enter text!", "Invalid Input");
            }
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            txtEnglish.Clear();
            txtPig.Clear();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private string toPigLatin(string english)
        {
            string[] words = english.Split();
            string pigLatin = "";
            foreach (string s in words)
            {
                if (isWord(s)) {
                    if (isVowel(s[0]))
                        if (isAlpha(s[s.Length - 1]))
                            pigLatin += s + "way ";
                        else
                            pigLatin += s.Substring(0, s.Length - 1) + "way" + s[s.Length - 1] + " ";
                    else
                    {
                        string cons = "" + s[0];
                        int i = 1;
                        while (!isVowel(s[i]) && s[i] != 'y' && s[i] != 'Y' && isAlpha(s[i]))
                        {
                            cons += s[i];
                            i++;
                        }
                        if (isAlpha(s[s.Length - 1]))
                            pigLatin += s.Substring(i) + cons + "ay ";
                        else
                            pigLatin += s.Substring(i, s.Length - i - 1) + cons + "ay" + s[s.Length - 1] + " ";

                    }
                }
                else
                {
                    pigLatin += s + " ";
                }
            }
            return pigLatin;
        }

        private bool isVowel(char c)
        {
            if (c == 'a' || c == 'A' ||
                c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' ||
                c == 'o' || c == 'O' ||
                c == 'u' || c == 'U')
                return true;
            else
                return false;
        }

        private bool isAlpha(char c)
        {
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122))
                return true;
            else
                return false;
        }

        private bool isPunct(char c)
        {
            if (c == '.' || c == ',' ||
                c == '!' || c == '?' ||
                c == '(' || c == ')' ||
                c == '\'' || c == '\"' ||
                c == ':' || c == ';')
                return true;
            else
                return false;
        }

        private bool isWord(string word)
        {
            foreach (char c in word)
            {
                if (!isAlpha(c) && !isPunct(c))
                    return false;
            }
            return true;
        }

        private bool isUpper(char c)
        {
            if (c >= 65 && c <= 90)
                return true;
            else
                return false;
        }

        private bool isLower(char c)
        {
            if (c >= 97 && c <= 122)
                return true;
            else
                return false;
        }

        private char toUpper(char c)
        {
            if (isLower(c))
                return (char)(c - 32);
            else
                return c;
        }

        private char toLower(char c)
        {
            if (isUpper(c))
                return (char)(c + 32);
            else
                return c;
        }
    }
}
