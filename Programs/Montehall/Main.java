public class Main{
/*Txt pg34, #2.20 
    *a)
    *S = {G, D1, D2}
    *P(G)=1/3 | P(D1)=1/3 | P(D2)=1/3
    *So, there's a 33% chance the contestant selects the winning curtain
    *  
    *b)
    *The strategy which maximizes the contestants chances of winning is to
    *switch curtains after being shown the dud, because now the set S = {G, D}
    *gives a 50% chance of selecting the winning curtain as opposed to the 33%
    *chance given at the start of the game when there were 3 choices. 
    */
   
    public static void main(String args[]) {
        MHTester t = new MHTester();
        t.checkPow10(7, 3);
    }
}