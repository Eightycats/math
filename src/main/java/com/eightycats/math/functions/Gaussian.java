package com.eightycats.math.functions;

/**
 * Bell curve.
 */
public class Gaussian
    implements Function
{
   @Override
   public double apply( double x )
   {
      return Math.exp(-x * x);
   }

   public static void main (String[] args)
   {
       FunctionProcessor.dump(new Gaussian());
   }
}
