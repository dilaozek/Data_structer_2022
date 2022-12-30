
public class Main {

public static void main(String [] args)
{
int[] nums = {31,1,56,33,777,123,25,15,17,20,11,10,1,23,3};

merge m = new merge();
m.Sort(nums);
print(nums);
}
private static void print(int[] nums)
{
for(int i = 0; i < nums.length; i++)
{
System.out.print(nums[i] + " ");
}
}
}