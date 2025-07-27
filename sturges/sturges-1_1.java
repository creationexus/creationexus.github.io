import java.lang.Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TablaFrecuencias {
	
    public TablaFrecuencias() {
    }
    public void m (Object m){
    	System.out.print(m);
    }
    public int c (float[][] data, float min, float max, float ini){
    	int count = 0;
    	//####- Se elimina el valor repetido del rango -####
    	//if(ini != min)
    	//	min++;
    	//####
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				if(data[i][j] >= min && data[i][j] < max)
				    count++;
			}
		}
		return count;		    	
    }
    public void s(float[][] data){
    	for(int i = 0; i < data.length; i++){
    		for(int j = 0; j < data[i].length; j++){
    			m(" ["+data[i][j]+"] ");
    		}
    		m("\n");
    	}
    	m("\n");
    }
    public void p(float[][] data, int ii, int jj){
    	for(int i = 0; i < data.length; i++){
    		for(int j = 0; j < data[i].length; j++){
    			if((i == ii) && (j == jj))
    				m("[ X ]");
    			else
    				m("[  ]");
    		}
    		m("\n");
    	}
    	m("\n");
    }    
    public static void main(String[] args) throws java.io.IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));        
        TablaFrecuencias tf = new TablaFrecuencias();
        int c, k, cElem, sumP, ff, cc;
        float min, max;
        
        tf.m("filas:");
        	ff = Integer.parseInt(in.readLine());
        tf.m("columnas:");
        	cc = Integer.parseInt(in.readLine());
        float tablaDat[][] = new float[ff][cc];
        
        float v; 
        for(int i = 0; i < tablaDat.length; i++){
        	for(int j = 0; j < tablaDat[i].length; j++){
        		tf.p(tablaDat, i, j);
        		tf.m("["+i+"]["+j+"]>");
				v = Float.parseFloat(in.readLine());
				tablaDat[i][j] = v;
        		tf.s(tablaDat);
        	}
        }
        
        
        cElem = tablaDat.length*tablaDat[0].length;
        //regla de 'Sturges'
        k = ((int)(3.3*Math.log10(cElem)))+1;
        
        min = tablaDat[0][0];
        max = tablaDat[0][0];
        sumP = 0;
        
        tf.s(tablaDat);
        
        //Se busca el minimo y maximo, ademas se suman todos los valores
        for(int i = 0; i < tablaDat.length; i++){
        	for(int j = 0; j < tablaDat[i].length; j++){
        		if(tablaDat[i][j] < min)
        			min = tablaDat[i][j];
        		if(tablaDat[i][j] > max)
        			max = tablaDat[i][j];
        		sumP += tablaDat[i][j];
        	}
        }
        
        c = Math.round((max-min)/k);
        
        float tablaFrec[][] = new float[k][7];
        float suma = 0;
        float sumaA = 0;
        float co = 0;
        
        //se calculan los valores de la tabla
        for(int i = 0; i < k; i++, suma += c){
            co = tf.c(tablaDat, min + suma, min + suma + c, min);
            sumaA += co;
        	tablaFrec[i][0] = min + suma;
        	tablaFrec[i][1] = min + suma + c;
        	tablaFrec[i][2] = ((tablaFrec[i][1] + tablaFrec[i][0])/2);
        	tablaFrec[i][3] = co;
        	tablaFrec[i][4] = (float)(co)/cElem;
        	tablaFrec[i][5] = sumaA;
        	tablaFrec[i][6] = sumaA/cElem;
            
        }
        
        for(int i = 0; i < k; i++){
        	tf.m("A"+i+" | ");
        	tf.m(tablaFrec[i][0]);
        	tf.m(" - ");
        	tf.m(tablaFrec[i][1]);
        	tf.m(" | ");
        	tf.m(tablaFrec[i][2]);
        	tf.m(" | ");
        	tf.m(tablaFrec[i][3]);
        	tf.m(" | ");
        	tf.m(tablaFrec[i][4]);
        	tf.m(" | ");
        	tf.m(tablaFrec[i][5]);
        	tf.m(" | ");
        	tf.m(tablaFrec[i][6]);
        	tf.m("\n");
        }
        
        tf.m("\nmin:"+min);
        tf.m("\nmax:"+max);        
        tf.m("\nk:"+k);
        tf.m("\nc:"+c);
        tf.m("\nmedia:"+(float)sumP/cElem);
    }
}