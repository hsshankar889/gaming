package gaming.controller;
import java.util.Random;
public class GeneratorClass {
	int[] a=new int[3];
	Random r=new Random();
public int[] generate()
{
	for(int i=0;i<a.length;i++) {
		a[i]=r.nextInt(10);
	}
	return a;
}
}
