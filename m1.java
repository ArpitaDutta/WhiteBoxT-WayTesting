/*
 * import javax.script.ScriptEngine;
 
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class m1 {
 static String exp="&|&|";
 static String original="(a&(!b|!c)&d|e)";
 static int actlen=exp.length();
 static int possible=(int)Math.pow(2,exp.length());

 static String fault1[]=new String[possible];
static String fault2[]=new String[possible];
static String fault3[]=new String[possible];

static String faultPossible[]=new String[possible];

static int cf1=0;
static int cf2=0;
static int cf3=0;



static int cft=0;

static int psb=32;
static String possibleboolean[]=new String[32];
static int possnum=0; 
static int pict[]=new int[]{26, 28, 23,5,29,9,2,14,31,24,15,4};
static int pict3w[]=new int[]{6,31,21,24,19,26,1,13,0,10,28,11,20};
static int mcdctc[]= new int[]{10,22,24,26,30,31};


    	 char a=curr.charAt(0);
         char b=curr.charAt(1);
         char c=curr.charAt(2);
         char d=curr.charAt(3);
         char e=curr.charAt(4);
         String expdata=original;
         expdata=expdata.replace("a", a+"");
         expdata=expdata.replace("b", b+"");
         expdata=expdata.replace("c", c+"");
         expdata=expdata.replace("d", d+"");
         expdata=expdata.replace("e", e+"");





*/
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class m1 {
	 static String exp="&|&|";
	 static String original="(a&(!b|!c)&d|e)";
 static int actlen=exp.length();
 static int possible=(int)Math.pow(2,exp.length());
static String fault1[]=new String[possible];
static String fault2[]=new String[possible];
static String fault3[]=new String[possible];
static String fault4[]=new String[possible];
static String fault5[]=new String[possible];
static String fault6[]=new String[possible];

static String faultPossible[]=new String[possible];
static int cf1=0;
static int cf2=0;
static int cf3=0;
static int cf4=0;
static int cf5=0;
static int cf6=0;

static int cft=0;
static int psb=32;
static String possibleboolean[]=new String[32];
static int possnum=0; 
static int pict[]=new int[]{26, 28, 23,5,29,9,2,14,31,24,15,4,1,11,22,19,20,7,16,25,17,8,12};
static int pict3w[]=new int[]{6,31,21,24,19,26,1,13,0,10,28,11,20};
static int mcdctc[]= new int[]{10,22,24,26,30,31};

    public static void main(String[] args) throws ScriptException {
        char[] alphabet = new char[] {'|','&'};
        char[] bool = new char[] {'0','1'};
        System.out.println("exp  "+exp);
        possibleStrings(actlen, alphabet,"");
        /*____________________computation for single fault___________________________________*/
        posboolean(5, bool, "");
        System.out.println("_____________________Single faults result___________________________");
        singlefault();
        System.out.println("_____________________Double faults result___________________________");
        doublefault();
        System.out.println("_____________________Triple faults result___________________________");
        triplefault();

        
        System.out.println("_____________________All possible faults result___________________________");
        //Allfault();
        
        System.out.println("_____________________Four faults result___________________________");
        fourfault();
        
        System.out.println("_____________________Five faults result___________________________");
        fivefault();
        
        System.out.println("_____________________Six faults result___________________________");
        sixfault();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void fourfault() throws ScriptException {
        String dataSF[][]=new String[psb][cf4+1];
        for(int i=0;i<psb;i++) {
       	 String curr=possibleboolean[i];
    	 char a=curr.charAt(0);
         char b=curr.charAt(1);
         char c=curr.charAt(2);
         char d=curr.charAt(3);
         char e=curr.charAt(4);
         String expdata=original;
         expdata=expdata.replace("a", a+"");
         expdata=expdata.replace("b", b+"");
         expdata=expdata.replace("c", c+"");
         expdata=expdata.replace("d", d+"");
         expdata=expdata.replace("e", e+"");
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine se = sem.getEngineByName("JavaScript");
            String exp_val=se.eval(expdata)+"";
            dataSF[i][0]=exp_val;
            //System.out.println("exp:"+exp_val);
        }
        for(int i=0;i<cf4;i++) {
       	 String expdata=original;
       	 String oper=fault4[i];
       	 System.out.println("oper:"+oper); 
       	 int nc=0;
       	 for(int j=0;j<expdata.length();j++) {
       		 if(expdata.charAt(j)=='|'||expdata.charAt(j)=='&') {
       			// System.out.println("original:"+original+"exp:"+expdata+i+nc); 
       			 expdata=expdata.substring(0, j)+oper.charAt(nc)+expdata.substring(j+1, expdata.length());
       			 nc++;
       		 }
       	 }
       	 System.out.println("original:___"+original+"exp:"+expdata); 
       	 String expdata2=expdata;
       	//__________________________________________ 
       	 for(int i1=0;i1<psb;i1++) {
           	 String curr=possibleboolean[i1];
        	 char a=curr.charAt(0);
             char b=curr.charAt(1);
             char c=curr.charAt(2);
             char d=curr.charAt(3);
             char e=curr.charAt(4);
      
             expdata=expdata.replace("a", a+"");
             expdata=expdata.replace("b", b+"");
             expdata=expdata.replace("c", c+"");
             expdata=expdata.replace("d", d+"");
             expdata=expdata.replace("e", e+"");
              ScriptEngineManager sem = new ScriptEngineManager();
                ScriptEngine se = sem.getEngineByName("JavaScript");
                String exp_val=se.eval(expdata)+"";
                dataSF[i1][i+1]=exp_val;
                expdata=expdata2;
                //System.out.print("exp:"+expdata);
            } 
        }
       	
       	//_______________________________now the result evaluation part is____________________
        int equal2=0;
        int equal3=0;
        int pct=0; 
        int pct3w=0;// pict
        int mcd2=0;
        int mcd3=0;// mcdc
        int ft_ov=0;
        int mcd_ov=0;
        int pct_ov=0;
        int pct3w_ov=0;
        for(int h3=0;h3<cf4+1;h3++ ){
            for(int h4=0;h4<psb;h4++){
                System.out.print("  "+dataSF[h4][h3]);
            }
            System.out.println();
        }
        for(int h3=1;h3<cf4+1;h3++){
            System.out.println("================for mutant"+h3+"=================");
                int count_faults=0;
                int pict_det=0;
                int pict3w_det=0;
                int mcdc_det=0;
                for(int h4=0;h4<psb;h4++){
                    if (!dataSF[h4][0].equals(dataSF[h4][h3])){
                      //  System.out.println("  "+dataSF[h4][0]+" * "+dataSF[h4][h3]);
                    System.out.print("  "+(h4));
                    for (int hh=0;hh<pict.length;hh++) {
                    	if(pict[hh]==h4) {pict_det++;}
                    }
                    for (int hh=0;hh<pict3w.length;hh++) {
                    	if(pict3w[hh]==h4) {pict3w_det++;}
                    }
                    for (int hh=0;hh<mcdctc.length;hh++) {
                    	if(mcdctc[hh]==h4) {mcdc_det++;}
                    }
                      count_faults++;
                      
                    }
                    
                }
                System.out.println("\n");
                ft_ov+=count_faults;
                mcd_ov+=mcdc_det;
                pct_ov+=pict_det;
                pct3w_ov+=pict3w_det;
                System.out.println(" Total Faults "+count_faults);
                
                System.out.println(" Faults Detected by Pict "+pict_det);
                System.out.println(" Faults Detected by MCDC "+mcdc_det);
                System.out.println(" Faults Detected by Pict-3way "+pict3w_det);
                 if (pict_det==mcdc_det){equal2++;}
                 else if(pict_det>mcdc_det){pct++;}
                 else {mcd2++;}
                 
                 if (pict3w_det==mcdc_det){equal3++;}
                 else if(pict3w_det>mcdc_det){pct3w++;}
                 else {mcd3++;} 
       }
        
        System.out.println("**************Comparison Between 2-way and MC/DC Testing***********************"); 
        System.out.println("=########################################################################################################################33======");
        System.out.println(" Equal Behavoir "+equal2); 
           System.out.println(" MC/DC is performing better  "+mcd2);
            System.out.println(" Pict 2 way is performing better  "+pct);

            System.out.println("*************************************");
            
            
            
             System.out.println("**************Comparison Between 3-way and MC/DC Testing***********************"); 
        System.out.println(" Equal Behavoir "+equal3); 
           
           System.out.println(" MC/DC is performing better  "+mcd3);
           
           System.out.println(" Pict  3 way is performing better  "+pct3w);
            System.out.println("*************************************");
            System.out.println("*************************************"); 
        System.out.println(" Overall Faults for expression  is "+ft_ov); 
           System.out.println(" Pict determined  "+pct_ov);
           System.out.println(" MC/DC dtermined  "+mcd_ov);
           System.out.println(" 3-way dtermined  "+pct3w_ov);
            System.out.println("*************************************");
       }   
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void fivefault() throws ScriptException {
        String dataSF[][]=new String[psb][cf5+1];
        for(int i=0;i<psb;i++) {
       	 String curr=possibleboolean[i];
    	 char a=curr.charAt(0);
         char b=curr.charAt(1);
         char c=curr.charAt(2);
         char d=curr.charAt(3);
         char e=curr.charAt(4);
         String expdata=original;
         expdata=expdata.replace("a", a+"");
         expdata=expdata.replace("b", b+"");
         expdata=expdata.replace("c", c+"");
         expdata=expdata.replace("d", d+"");
         expdata=expdata.replace("e", e+"");
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine se = sem.getEngineByName("JavaScript");
            String exp_val=se.eval(expdata)+"";
            dataSF[i][0]=exp_val;
            //System.out.println("exp:"+exp_val);
        }
        for(int i=0;i<cf5;i++) {
       	 String expdata=original;
       	 String oper=fault5[i];
       	 System.out.println("oper:"+oper); 
       	 int nc=0;
       	 for(int j=0;j<expdata.length();j++) {
       		 if(expdata.charAt(j)=='|'||expdata.charAt(j)=='&') {
       			// System.out.println("original:"+original+"exp:"+expdata+i+nc); 
       			 expdata=expdata.substring(0, j)+oper.charAt(nc)+expdata.substring(j+1, expdata.length());
       			 nc++;
       		 }
       	 }
       	 System.out.println("original:___"+original+"exp:"+expdata); 
       	 String expdata2=expdata;
       	//__________________________________________ 
       	 for(int i1=0;i1<psb;i1++) {
           	 String curr=possibleboolean[i1];
        	 char a=curr.charAt(0);
             char b=curr.charAt(1);
             char c=curr.charAt(2);
             char d=curr.charAt(3);
             char e=curr.charAt(4);
             expdata=expdata.replace("a", a+"");
             expdata=expdata.replace("b", b+"");
             expdata=expdata.replace("c", c+"");
             expdata=expdata.replace("d", d+"");
             expdata=expdata.replace("e", e+"");
                ScriptEngineManager sem = new ScriptEngineManager();
                ScriptEngine se = sem.getEngineByName("JavaScript");
                String exp_val=se.eval(expdata)+"";
                dataSF[i1][i+1]=exp_val;
                expdata=expdata2;
                //System.out.print("exp:"+expdata);
            } 
        }
       	
       	//_______________________________now the result evaluation part is____________________
        int equal2=0;
        int equal3=0;
        int pct=0; 
        int pct3w=0;// pict
        int mcd2=0;
        int mcd3=0;// mcdc
        int ft_ov=0;
        int mcd_ov=0;
        int pct_ov=0;
        int pct3w_ov=0;
        for(int h3=0;h3<cf5+1;h3++ ){
            for(int h4=0;h4<psb;h4++){
                System.out.print("  "+dataSF[h4][h3]);
            }
            System.out.println();
        }
        for(int h3=1;h3<cf5+1;h3++){
            System.out.println("================for mutant"+h3+"=================");
                int count_faults=0;
                int pict_det=0;
                int pict3w_det=0;
                int mcdc_det=0;
                for(int h4=0;h4<psb;h4++){
                    if (!dataSF[h4][0].equals(dataSF[h4][h3])){
                      //  System.out.println("  "+dataSF[h4][0]+" * "+dataSF[h4][h3]);
                    System.out.print("  "+(h4));
                    for (int hh=0;hh<pict.length;hh++) {
                    	if(pict[hh]==h4) {pict_det++;}
                    }
                    for (int hh=0;hh<pict3w.length;hh++) {
                    	if(pict3w[hh]==h4) {pict3w_det++;}
                    }
                    for (int hh=0;hh<mcdctc.length;hh++) {
                    	if(mcdctc[hh]==h4) {mcdc_det++;}
                    }
                      count_faults++;
                      
                    }
                    
                }
                System.out.println("\n");
                ft_ov+=count_faults;
                mcd_ov+=mcdc_det;
                pct_ov+=pict_det;
                pct3w_ov+=pict3w_det;
                System.out.println(" Total Faults "+count_faults);
                
                System.out.println(" Faults Detected by Pict "+pict_det);
                System.out.println(" Faults Detected by MCDC "+mcdc_det);
                System.out.println(" Faults Detected by Pict-3way "+pict3w_det);
                 if (pict_det==mcdc_det){equal2++;}
                 else if(pict_det>mcdc_det){pct++;}
                 else {mcd2++;}
                 
                 if (pict3w_det==mcdc_det){equal3++;}
                 else if(pict3w_det>mcdc_det){pct3w++;}
                 else {mcd3++;} 
       }
        
        System.out.println("**************Comparison Between 2-way and MC/DC Testing***********************"); 
        System.out.println("=########################################################################################################################33======");
        System.out.println(" Equal Behavoir "+equal2); 
           System.out.println(" MC/DC is performing better  "+mcd2);
            System.out.println(" Pict 2 way is performing better  "+pct);

            System.out.println("*************************************");
            
            
            
             System.out.println("**************Comparison Between 3-way and MC/DC Testing***********************"); 
        System.out.println(" Equal Behavoir "+equal3); 
           
           System.out.println(" MC/DC is performing better  "+mcd3);
           
           System.out.println(" Pict  3 way is performing better  "+pct3w);
            System.out.println("*************************************");
            System.out.println("*************************************"); 
        System.out.println(" Overall Faults for expression  is "+ft_ov); 
           System.out.println(" Pict determined  "+pct_ov);
           System.out.println(" MC/DC dtermined  "+mcd_ov);
           System.out.println(" 3-way dtermined  "+pct3w_ov);
            System.out.println("*************************************");
       }   
    
    
    
    
    
    
    public static void sixfault() throws ScriptException {
        String dataSF[][]=new String[psb][cf6+1];
        for(int i=0;i<psb;i++) {
       	 String curr=possibleboolean[i];
    	 char a=curr.charAt(0);
         char b=curr.charAt(1);
         char c=curr.charAt(2);
         char d=curr.charAt(3);
         char e=curr.charAt(4);
         String expdata=original;
         expdata=expdata.replace("a", a+"");
         expdata=expdata.replace("b", b+"");
         expdata=expdata.replace("c", c+"");
         expdata=expdata.replace("d", d+"");
         expdata=expdata.replace("e", e+"");
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine se = sem.getEngineByName("JavaScript");
            String exp_val=se.eval(expdata)+"";
            dataSF[i][0]=exp_val;
            //System.out.println("exp:"+exp_val);
        }
        for(int i=0;i<cf6;i++) {
       	 String expdata=original;
       	 String oper=fault6[i];
       	 System.out.println("oper:"+oper); 
       	 int nc=0;
       	 for(int j=0;j<expdata.length();j++) {
       		 if(expdata.charAt(j)=='|'||expdata.charAt(j)=='&') {
       			// System.out.println("original:"+original+"exp:"+expdata+i+nc); 
       			 expdata=expdata.substring(0, j)+oper.charAt(nc)+expdata.substring(j+1, expdata.length());
       			 nc++;
       		 }
       	 }
       	 System.out.println("original:___"+original+"exp:"+expdata); 
       	 String expdata2=expdata;
       	//__________________________________________ 
       	 for(int i1=0;i1<psb;i1++) {
           	 String curr=possibleboolean[i1];
        	 char a=curr.charAt(0);
             char b=curr.charAt(1);
             char c=curr.charAt(2);
             char d=curr.charAt(3);
             char e=curr.charAt(4);
             expdata=expdata.replace("a", a+"");
             expdata=expdata.replace("b", b+"");
             expdata=expdata.replace("c", c+"");
             expdata=expdata.replace("d", d+"");
             expdata=expdata.replace("e", e+"");
                ScriptEngineManager sem = new ScriptEngineManager();
                ScriptEngine se = sem.getEngineByName("JavaScript");
                String exp_val=se.eval(expdata)+"";
                dataSF[i1][i+1]=exp_val;
                expdata=expdata2;
                //System.out.print("exp:"+expdata);
            } 
        }
       	
       	//_______________________________now the result evaluation part is____________________
        int equal2=0;
        int equal3=0;
        int pct=0; 
        int pct3w=0;// pict
        int mcd2=0;
        int mcd3=0;// mcdc
        int ft_ov=0;
        int mcd_ov=0;
        int pct_ov=0;
        int pct3w_ov=0;
        for(int h3=0;h3<cf6+1;h3++ ){
            for(int h4=0;h4<psb;h4++){
                System.out.print("  "+dataSF[h4][h3]);
            }
            System.out.println();
        }
        for(int h3=1;h3<cf6+1;h3++){
            System.out.println("================for mutant"+h3+"=================");
                int count_faults=0;
                int pict_det=0;
                int pict3w_det=0;
                int mcdc_det=0;
                for(int h4=0;h4<psb;h4++){
                    if (!dataSF[h4][0].equals(dataSF[h4][h3])){
                      //  System.out.println("  "+dataSF[h4][0]+" * "+dataSF[h4][h3]);
                    System.out.print("  "+(h4));
                    for (int hh=0;hh<pict.length;hh++) {
                    	if(pict[hh]==h4) {pict_det++;}
                    }
                    for (int hh=0;hh<pict3w.length;hh++) {
                    	if(pict3w[hh]==h4) {pict3w_det++;}
                    }
                    for (int hh=0;hh<mcdctc.length;hh++) {
                    	if(mcdctc[hh]==h4) {mcdc_det++;}
                    }
                      count_faults++;
                      
                    }
                    
                }
                System.out.println("\n");
                ft_ov+=count_faults;
                mcd_ov+=mcdc_det;
                pct_ov+=pict_det;
                pct3w_ov+=pict3w_det;
                System.out.println(" Total Faults "+count_faults);
                
                System.out.println(" Faults Detected by Pict "+pict_det);
                System.out.println(" Faults Detected by MCDC "+mcdc_det);
                System.out.println(" Faults Detected by Pict-3way "+pict3w_det);
                 if (pict_det==mcdc_det){equal2++;}
                 else if(pict_det>mcdc_det){pct++;}
                 else {mcd2++;}
                 
                 if (pict3w_det==mcdc_det){equal3++;}
                 else if(pict3w_det>mcdc_det){pct3w++;}
                 else {mcd3++;} 
       }
        
        System.out.println("**************Comparison Between 2-way and MC/DC Testing***********************"); 
        System.out.println("=########################################################################################################################33======");
        System.out.println(" Equal Behavoir "+equal2); 
           System.out.println(" MC/DC is performing better  "+mcd2);
            System.out.println(" Pict 2 way is performing better  "+pct);

            System.out.println("*************************************");
            
            
            
             System.out.println("**************Comparison Between 3-way and MC/DC Testing***********************"); 
        System.out.println(" Equal Behavoir "+equal3); 
           
           System.out.println(" MC/DC is performing better  "+mcd3);
           
           System.out.println(" Pict  3 way is performing better  "+pct3w);
            System.out.println("*************************************");
            System.out.println("*************************************"); 
        System.out.println(" Overall Faults for expression  is "+ft_ov); 
           System.out.println(" Pict determined  "+pct_ov);
           System.out.println(" MC/DC dtermined  "+mcd_ov);
           System.out.println(" 3-way dtermined  "+pct3w_ov);
            System.out.println("*************************************");
       }   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void singlefault() throws ScriptException {
     String dataSF[][]=new String[psb][cf1+1];
     for(int i=0;i<psb;i++) {
    	 String curr=possibleboolean[i];
    	 char a=curr.charAt(0);
         char b=curr.charAt(1);
         char c=curr.charAt(2);
         char d=curr.charAt(3);
         char e=curr.charAt(4);
         String expdata=original;
         expdata=expdata.replace("a", a+"");
         expdata=expdata.replace("b", b+"");
         expdata=expdata.replace("c", c+"");
         expdata=expdata.replace("d", d+"");
         expdata=expdata.replace("e", e+"");
        ScriptEngineManager sem = new ScriptEngineManager();
         ScriptEngine se = sem.getEngineByName("JavaScript");
         String exp_val=se.eval(expdata)+"";
         dataSF[i][0]=exp_val;
         //System.out.println("exp:"+exp_val);
     }
     for(int i=0;i<cf1;i++) {
    	 String expdata=original;
    	 String oper=fault1[i];
    	 System.out.println("oper:"+oper); 
    	 int nc=0;
    	 for(int j=0;j<expdata.length()&&nc<exp.length();j++) {
    		 if(expdata.charAt(j)=='|'||expdata.charAt(j)=='&') {
    			// System.out.println("original:"+original+"exp:"+expdata+i+nc); 
    			 expdata=expdata.substring(0, j)+oper.charAt(nc)+expdata.substring(j+1, expdata.length());
    			 nc++;
    		 }
    	 }
    	 System.out.println("original:___"+original+"exp:"+expdata); 
    	 String expdata2=expdata;
    	//__________________________________________ 
    	 for(int i1=0;i1<psb;i1++) {
        	 String curr=possibleboolean[i1];
        	 char a=curr.charAt(0);
             char b=curr.charAt(1);
             char c=curr.charAt(2);
             char d=curr.charAt(3);
             char e=curr.charAt(4);
             expdata=expdata.replace("a", a+"");
             expdata=expdata.replace("b", b+"");
             expdata=expdata.replace("c", c+"");
             expdata=expdata.replace("d", d+"");
             expdata=expdata.replace("e", e+"");
           ScriptEngineManager sem = new ScriptEngineManager();
             ScriptEngine se = sem.getEngineByName("JavaScript");
             String exp_val=se.eval(expdata)+"";
             dataSF[i1][i+1]=exp_val;
             expdata=expdata2;
             //System.out.print("exp:"+expdata);
         } 
     }
    	
    	//_______________________________now the result evaluation part is____________________
     int equal2=0;
     int equal3=0;
     int pct=0; 
     int pct3w=0;// pict
     int mcd2=0;
     int mcd3=0;// mcdc
     int ft_ov=0;
     int mcd_ov=0;
     int pct_ov=0;
     int pct3w_ov=0;
     for(int h3=0;h3<cf1+1;h3++ ){
         for(int h4=0;h4<psb;h4++){
             System.out.print("  "+dataSF[h4][h3]);
         }
         System.out.println();
     }
     for(int h3=1;h3<cf1+1;h3++){
         System.out.println("================for mutant"+h3+"=================");
             int count_faults=0;
             int pict_det=0;
             int pict3w_det=0;
             int mcdc_det=0;
             for(int h4=0;h4<psb;h4++){
                 if (!dataSF[h4][0].equals(dataSF[h4][h3])){
                   //  System.out.println("  "+dataSF[h4][0]+" * "+dataSF[h4][h3]);
                 System.out.print("  "+(h4));
                 for (int hh=0;hh<pict.length;hh++) {
                 	if(pict[hh]==h4) {pict_det++;}
                 }
                 for (int hh=0;hh<pict3w.length;hh++) {
                 	if(pict3w[hh]==h4) {pict3w_det++;}
                 }
                 for (int hh=0;hh<mcdctc.length;hh++) {
                 	if(mcdctc[hh]==h4) {mcdc_det++;}
                 }
                   count_faults++;
                   
                 }
                 
             }
             System.out.println("\n");
             ft_ov+=count_faults;
             mcd_ov+=mcdc_det;
             pct_ov+=pict_det;
             pct3w_ov+=pict3w_det;
             System.out.println(" Total Faults "+count_faults);
             
             System.out.println(" Faults Detected by Pict "+pict_det);
             System.out.println(" Faults Detected by MCDC "+mcdc_det);
             System.out.println(" Faults Detected by Pict-3way "+pict3w_det);
              if (pict_det==mcdc_det){equal2++;}
              else if(pict_det>mcdc_det){pct++;}
              else {mcd2++;}
              
              if (pict3w_det==mcdc_det){equal3++;}
              else if(pict3w_det>mcdc_det){pct3w++;}
              else {mcd3++;} 
    }
     
     System.out.println("**************Comparison Between 2-way and MC/DC Testing***********************"); 
     System.out.println("=########################################################################################################################33======");
     System.out.println(" Equal Behavoir "+equal2); 
        System.out.println(" MC/DC is performing better  "+mcd2);
         System.out.println(" Pict 2 way is performing better  "+pct);

         System.out.println("*************************************");
         
         
         
          System.out.println("**************Comparison Between 3-way and MC/DC Testing***********************"); 
     System.out.println(" Equal Behavoir "+equal3); 
        
        System.out.println(" MC/DC is performing better  "+mcd3);
        
        System.out.println(" Pict  3 way is performing better  "+pct3w);
         System.out.println("*************************************");
         System.out.println("*************************************"); 
     System.out.println(" Overall Faults for expression  is "+ft_ov); 
        System.out.println(" Pict determined  "+pct_ov);
        System.out.println(" MC/DC dtermined  "+mcd_ov);
        System.out.println(" 3-way dtermined  "+pct3w_ov);
         System.out.println("*************************************");
    }   
    
    public static void Allfault() throws ScriptException {
        String dataSF[][]=new String[psb][cft+1];
        for(int i=0;i<psb;i++) {
       	 String curr=possibleboolean[i];
    	 char a=curr.charAt(0);
         char b=curr.charAt(1);
         char c=curr.charAt(2);
         char d=curr.charAt(3);
         char e=curr.charAt(4);
         String expdata=original;
         expdata=expdata.replace("a", a+"");
         expdata=expdata.replace("b", b+"");
         expdata=expdata.replace("c", c+"");
         expdata=expdata.replace("d", d+"");
         expdata=expdata.replace("e", e+"");
           ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine se = sem.getEngineByName("JavaScript");
            String exp_val=se.eval(expdata)+"";
            dataSF[i][0]=exp_val;
            //System.out.println("exp:"+exp_val);
        }
        for(int i=0;i<cft;i++) {
       	 String expdata=original;
       	 String oper=faultPossible[i];
       	 //System.out.println("oper:"+oper); 
       	 int nc=0;
       	 for(int j=0;j<expdata.length();j++) {
       		 if(expdata.charAt(j)=='|'||expdata.charAt(j)=='&') {
       			 //System.out.println("original:"+original+"exp:"+expdata+i); 
       			 expdata=expdata.substring(0, j)+oper.charAt(nc)+expdata.substring(j+1, expdata.length());
       			 nc++;
       		 }
       	 }
       	 System.out.println("original:"+original+"exp:"+expdata); 
       	String expdata2=expdata;
       	//__________________________________________ 
       	 for(int i1=0;i1<psb;i1++) {
           	 String curr=possibleboolean[i1];
        	 char a=curr.charAt(0);
             char b=curr.charAt(1);
             char c=curr.charAt(2);
             char d=curr.charAt(3);
             char e=curr.charAt(4);
             expdata=expdata.replace("a", a+"");
             expdata=expdata.replace("b", b+"");
             expdata=expdata.replace("c", c+"");
             expdata=expdata.replace("d", d+"");
             expdata=expdata.replace("e", e+"");
                ScriptEngineManager sem = new ScriptEngineManager();
                ScriptEngine se = sem.getEngineByName("JavaScript");
                String exp_val=se.eval(expdata)+"";
                dataSF[i1][i+1]=exp_val;
                expdata=expdata2;
               // System.out.print("exp:"+exp_val);
            } 
        }
       	
       	//_______________________________now the result evaluation part is____________________
        int equal2=0;
        int equal3=0;
        int pct=0; 
        int pct3w=0;// pict
        int mcd2=0;
        int mcd3=0;// mcdc
        int ft_ov=0;
        int mcd_ov=0;
        int pct_ov=0;
        int pct3w_ov=0;
        for(int h3=0;h3<cft+1;h3++ ){
            for(int h4=0;h4<psb;h4++){
                System.out.print("  "+dataSF[h4][h3]);
            }
            System.out.println();
        }
        for(int h3=1;h3<cft+1;h3++){
            System.out.println("================for mutant"+h3+"=================");
                int count_faults=0;
                int pict_det=0;
                int pict3w_det=0;
                int mcdc_det=0;
                for(int h4=0;h4<psb;h4++){
                    if (!dataSF[h4][0].equals(dataSF[h4][h3])){
                      //  System.out.println("  "+dataSF[h4][0]+" * "+dataSF[h4][h3]);
                    System.out.print("  "+(h4));
                    for (int hh=0;hh<pict.length;hh++) {
                    	if(pict[hh]==h4) {pict_det++;}
                    }
                    for (int hh=0;hh<pict3w.length;hh++) {
                    	if(pict3w[hh]==h4) {pict3w_det++;}
                    }
                    for (int hh=0;hh<mcdctc.length;hh++) {
                    	if(mcdctc[hh]==h4) {mcdc_det++;}
                    }
                      count_faults++;
                      
                    }
                    
                }
                System.out.println("\n");
                ft_ov+=count_faults;
                mcd_ov+=mcdc_det;
                pct_ov+=pict_det;
                pct3w_ov+=pict3w_det;
                System.out.println(" Total Faults "+count_faults);
                
                System.out.println(" Faults Detected by Pict "+pict_det);
                System.out.println(" Faults Detected by MCDC "+mcdc_det);
                System.out.println(" Faults Detected by Pict-3way "+pict3w_det);
                 if (pict_det==mcdc_det){equal2++;}
                 else if(pict_det>mcdc_det){pct++;}
                 else {mcd2++;}
                 
                 if (pict3w_det==mcdc_det){equal3++;}
                 else if(pict3w_det>mcdc_det){pct3w++;}
                 else {mcd3++;} 
       }
        
        System.out.println("**************Comparison Between 2-way and MC/DC Testing***********************"); 
        System.out.println("=########################################################################################################################33======");
        System.out.println(" Equal Behavoir "+equal2); 
           System.out.println(" MC/DC is performing better  "+mcd2);
            System.out.println(" Pict 2 way is performing better  "+pct);

            System.out.println("*************************************");
            
            
            
             System.out.println("**************Comparison Between 3-way and MC/DC Testing***********************"); 
        System.out.println(" Equal Behavoir "+equal3); 
           
           System.out.println(" MC/DC is performing better  "+mcd3);
           
           System.out.println(" Pict  3 way is performing better  "+pct3w);
            System.out.println("*************************************");
            System.out.println("*************************************"); 
        System.out.println(" Overall Faults for expression  is "+ft_ov); 
           System.out.println(" Pict determined  "+pct_ov);
           System.out.println(" MC/DC dtermined  "+mcd_ov);
           System.out.println(" 3-way dtermined  "+pct3w_ov);
            System.out.println("*************************************");
       }   
    public static void posboolean(int maxLength, char[] alphabet, String curr) {
        if(curr.length() == maxLength) {
            //System.out.println(curr);
            possibleboolean[possnum++]=curr;
        } else {
            for(int i = 0; i < alphabet.length; i++) {
                String oldCurr = curr;
                curr += alphabet[i];
                posboolean(maxLength,alphabet,curr);
                curr = oldCurr;
            }
        }
    }

    
    public static void doublefault() throws ScriptException {
        String dataSF[][]=new String[psb][cf2+1];
        for(int i=0;i<psb;i++) {
       	 String curr=possibleboolean[i];
    	 char a=curr.charAt(0);
         char b=curr.charAt(1);
         char c=curr.charAt(2);
         char d=curr.charAt(3);
         char e=curr.charAt(4);
         String expdata=original;
         expdata=expdata.replace("a", a+"");
         expdata=expdata.replace("b", b+"");
         expdata=expdata.replace("c", c+"");
         expdata=expdata.replace("d", d+"");
         expdata=expdata.replace("e", e+"");
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine se = sem.getEngineByName("JavaScript");
            String exp_val=se.eval(expdata)+"";
            dataSF[i][0]=exp_val;
            //System.out.println("exp:"+exp_val);
        }
        for(int i=0;i<cf2;i++) {
       	 String expdata=original;
       	 String oper=fault2[i];
       	 //System.out.println("oper:"+oper); 
       	 int nc=0;
       	 for(int j=0;j<expdata.length();j++) {
       		 if(expdata.charAt(j)=='|'||expdata.charAt(j)=='&') {
       			 //System.out.println("original:"+original+"exp:"+expdata+i); 
       			 expdata=expdata.substring(0, j)+oper.charAt(nc)+expdata.substring(j+1, expdata.length());
       			 nc++;
       		 }
       	 }
       	 System.out.println("original:"+original+"exp:"+expdata); 
       	//__________________________________________ 
       	String expdata2=expdata;
       	 for(int i1=0;i1<psb;i1++) {
           	 String curr=possibleboolean[i1];
        	 char a=curr.charAt(0);
             char b=curr.charAt(1);
             char c=curr.charAt(2);
             char d=curr.charAt(3);
             char e=curr.charAt(4);
             expdata=expdata.replace("a", a+"");
             expdata=expdata.replace("b", b+"");
             expdata=expdata.replace("c", c+"");
             expdata=expdata.replace("d", d+"");
             expdata=expdata.replace("e", e+"");
                ScriptEngineManager sem = new ScriptEngineManager();
                ScriptEngine se = sem.getEngineByName("JavaScript");
                String exp_val=se.eval(expdata)+"";
                dataSF[i1][i+1]=exp_val;
                expdata=expdata2;
               // System.out.print("exp:"+exp_val);
            } 
        }
       	
       	//_______________________________now the result evaluation part is____________________
        int equal2=0;
        int equal3=0;
        int pct=0; 
        int pct3w=0;// pict
        int mcd2=0;
        int mcd3=0;// mcdc
        int ft_ov=0;
        int mcd_ov=0;
        int pct_ov=0;
        int pct3w_ov=0;
        for(int h3=0;h3<cf2+1;h3++ ){
            for(int h4=0;h4<psb;h4++){
                System.out.print("  "+dataSF[h4][h3]);
            }
            System.out.println();
        }
        for(int h3=1;h3<cf2+1;h3++){
            System.out.println("================for mutant"+h3+"=================");
                int count_faults=0;
                int pict_det=0;
                int pict3w_det=0;
                int mcdc_det=0;
                for(int h4=0;h4<psb;h4++){
                    if (!dataSF[h4][0].equals(dataSF[h4][h3])){
                    //    System.out.println("  "+dataSF[h4][0]+" * "+dataSF[h4][h3]);
                    System.out.print("  "+(h4));
                    for (int hh=0;hh<pict.length;hh++) {
                    	if(pict[hh]==h4) {pict_det++;}
                    }
                    for (int hh=0;hh<pict3w.length;hh++) {
                    	if(pict3w[hh]==h4) {pict3w_det++;}
                    }
                    for (int hh=0;hh<mcdctc.length;hh++) {
                    	if(mcdctc[hh]==h4) {mcdc_det++;}
                    }
                      count_faults++;
                      
                    }
                    
                }
                System.out.println("\n");
                ft_ov+=count_faults;
                mcd_ov+=mcdc_det;
                pct_ov+=pict_det;
                pct3w_ov+=pict3w_det;
                System.out.println(" Total Faults "+count_faults);
                
                System.out.println(" Faults Detected by Pict "+pict_det);
                System.out.println(" Faults Detected by MCDC "+mcdc_det);
                System.out.println(" Faults Detected by Pict-3way "+pict3w_det);
                 if (pict_det==mcdc_det){equal2++;}
                 else if(pict_det>mcdc_det){pct++;}
                 else {mcd2++;}
                 
                 if (pict3w_det==mcdc_det){equal3++;}
                 else if(pict3w_det>mcdc_det){pct3w++;}
                 else {mcd3++;} 
       }
        
        System.out.println("**************Comparison Between 2-way and MC/DC Testing***********************"); 
        System.out.println("=########################################################################################################################33======");
        System.out.println(" Equal Behavoir "+equal2); 
           System.out.println(" MC/DC is performing better  "+mcd2);
            System.out.println(" Pict 2 way is performing better  "+pct);

            System.out.println("*************************************");
            
            
            
             System.out.println("**************Comparison Between 3-way and MC/DC Testing***********************"); 
        System.out.println(" Equal Behavoir "+equal3); 
           
           System.out.println(" MC/DC is performing better  "+mcd3);
           
           System.out.println(" Pict  3 way is performing better  "+pct3w);
            System.out.println("*************************************");
            System.out.println("*************************************"); 
     System.out.println(" Overall Faults for expression is "+ft_ov); 
           System.out.println(" Pict determined  "+pct_ov);
           System.out.println(" MC/DC dtermined  "+mcd_ov);
           System.out.println(" 3-way dtermined  "+pct3w_ov);
            System.out.println("*************************************");
       }   
    public static void triplefault() throws ScriptException {
        String dataSF[][]=new String[psb][cf3+1];
        for(int i=0;i<psb;i++) {
       	 String curr=possibleboolean[i];
    	 char a=curr.charAt(0);
         char b=curr.charAt(1);
         char c=curr.charAt(2);
         char d=curr.charAt(3);
         char e=curr.charAt(4);
         String expdata=original;
         expdata=expdata.replace("a", a+"");
         expdata=expdata.replace("b", b+"");
         expdata=expdata.replace("c", c+"");
         expdata=expdata.replace("d", d+"");
         expdata=expdata.replace("e", e+"");
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine se = sem.getEngineByName("JavaScript");
            String exp_val=se.eval(expdata)+"";
            dataSF[i][0]=exp_val;
            //System.out.println("exp:"+exp_val);
        }
        for(int i=0;i<cf3;i++) {
       	 String expdata=original;
       	 String oper=fault3[i];
       	 //System.out.println("oper:"+oper); 
       	 int nc=0;
       	 for(int j=0;j<expdata.length();j++) {
       		 if(expdata.charAt(j)=='|'||expdata.charAt(j)=='&') {
       			 //System.out.println("original:"+original+"exp:"+expdata+i); 
       			 expdata=expdata.substring(0, j)+oper.charAt(nc)+expdata.substring(j+1, expdata.length());
       			 nc++;
       		 }
       	 }
       	 System.out.println("original:"+original+"exp:"+expdata);
       	String expdata2=expdata;
       	//__________________________________________ 
       	 for(int i1=0;i1<psb;i1++) {
           	 String curr=possibleboolean[i1];
        	 char a=curr.charAt(0);
             char b=curr.charAt(1);
             char c=curr.charAt(2);
             char d=curr.charAt(3);
             char e=curr.charAt(4);
             expdata=expdata.replace("a", a+"");
             expdata=expdata.replace("b", b+"");
             expdata=expdata.replace("c", c+"");
             expdata=expdata.replace("d", d+"");
             expdata=expdata.replace("e", e+"");
                ScriptEngineManager sem = new ScriptEngineManager();
                ScriptEngine se = sem.getEngineByName("JavaScript");
                String exp_val=se.eval(expdata)+"";
                dataSF[i1][i+1]=exp_val;
                expdata=expdata2;
               // System.out.print("exp:"+exp_val);
            } 
        }
       	
       	//_______________________________now the result evaluation part is____________________
        int equal2=0;
        int equal3=0;
        int pct=0; 
        int pct3w=0;// pict
        int mcd2=0;
        int mcd3=0;// mcdc
        int ft_ov=0;
        int mcd_ov=0;
        int pct_ov=0;
        int pct3w_ov=0;
        for(int h3=0;h3<cf3+1;h3++ ){
            for(int h4=0;h4<psb;h4++){
                System.out.print("  "+dataSF[h4][h3]);
            }
            System.out.println();
        }
        for(int h3=1;h3<cf3+1;h3++){
            System.out.println("================for mutant"+h3+"=================");
                int count_faults=0;
                int pict_det=0;
                int pict3w_det=0;
                int mcdc_det=0;
                for(int h4=0;h4<psb;h4++){
                    if (!dataSF[h4][0].equals(dataSF[h4][h3])){
                     //   System.out.println("  "+dataSF[h4][0]+" * "+dataSF[h4][h3]);
                    System.out.print("  "+(h4));
                    for (int hh=0;hh<pict.length;hh++) {
                    	if(pict[hh]==h4) {pict_det++;}
                    }
                    for (int hh=0;hh<pict3w.length;hh++) {
                    	if(pict3w[hh]==h4) {pict3w_det++;}
                    }
                    for (int hh=0;hh<mcdctc.length;hh++) {
                    	if(mcdctc[hh]==h4) {mcdc_det++;}
                    }
                      count_faults++;
                      
                    }
                    
                }
                System.out.println("\n");
                ft_ov+=count_faults;
                mcd_ov+=mcdc_det;
                pct_ov+=pict_det;
                pct3w_ov+=pict3w_det;
                System.out.println(" Total Faults "+count_faults);
                
                System.out.println(" Faults Detected by Pict "+pict_det);
                System.out.println(" Faults Detected by MCDC "+mcdc_det);
                System.out.println(" Faults Detected by Pict-3way "+pict3w_det);
                 if (pict_det==mcdc_det){equal2++;}
                 else if(pict_det>mcdc_det){pct++;}
                 else {mcd2++;}
                 
                 if (pict3w_det==mcdc_det){equal3++;}
                 else if(pict3w_det>mcdc_det){pct3w++;}
                 else {mcd3++;} 
       }
        
        System.out.println("**************Comparison Between 2-way and MC/DC Testing***********************"); 
        System.out.println("=########################################################################################################################33======");
        System.out.println(" Equal Behavoir "+equal2); 
           System.out.println(" MC/DC is performing better  "+mcd2);
            System.out.println(" Pict 2 way is performing better  "+pct);

            System.out.println("*************************************");
            
            
            
             System.out.println("**************Comparison Between 3-way and MC/DC Testing***********************"); 
        System.out.println(" Equal Behavoir "+equal3); 
           
           System.out.println(" MC/DC is performing better  "+mcd3);
           
           System.out.println(" Pict  3 way is performing better  "+pct3w);
            System.out.println("*************************************");
            System.out.println("*************************************"); 
       System.out.println(" Overall Faults for expression   is "+ft_ov); 
           System.out.println(" Pict determined  "+pct_ov);
           System.out.println(" MC/DC dtermined  "+mcd_ov);
           System.out.println(" 3-way dtermined  "+pct3w_ov);
            System.out.println("*************************************");
       }   
       
      
    public static void possibleStrings(int maxLength, char[] alphabet, String curr) {

     
        // If the current string has reached it's maximum length
        if(curr.length() == maxLength) {
            System.out.println(curr);
            int countfaults=0;
             for(int i=0;i<curr.length();i++) {
            	 if(curr.charAt(i)!=exp.charAt(i)) {countfaults++;}
             }
             System.out.println(countfaults);
             if(countfaults==1){
                 fault1[cf1++]=curr;
             }else if(countfaults==2){
                 fault2[cf2++]=curr;
             }else if(countfaults==3){
                 fault3[cf3++]=curr;
             }else if(countfaults==4){
                  fault4[cf4++]=curr;
             }else if(countfaults==5){
                 fault5[cf5++]=curr;
             }else {
            	 if(countfaults==6){          
                 fault6[cf6++]=curr;
            	 }
             }
             if(curr.equals(exp)) {}
             else {  faultPossible[cft++]=curr;}
        // Else add each letter from the alphabet to new strings and process these new strings again
        } else {
            for(int i = 0; i < alphabet.length; i++) {
                String oldCurr = curr;
                curr += alphabet[i];
                possibleStrings(maxLength,alphabet,curr);
                curr = oldCurr;
            }
        }
}
}