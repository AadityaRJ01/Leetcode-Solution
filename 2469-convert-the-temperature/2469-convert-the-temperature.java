class Solution {
    public double[] convertTemperature(double celsius) {
        double[] temp=new double[2];
        double Kelvin=celsius+273.15;
        double Fahr=celsius*1.80+32.00;
        return new double[]{Kelvin,Fahr};
    }
}