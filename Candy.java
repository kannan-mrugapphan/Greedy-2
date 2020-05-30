// 135.
// greedy approach - initially give 1 candy to each child, in the left pass, check if a child has higher rating than its left neighbour, if so increase candy, in right pass, check if a child has high rating than its right neighbour and has lower candy, then increase candy
//time - O(n)
//space - O(n)
class Solution {
    public int candy(int[] ratings) {
        //edge
        if(ratings == null || ratings.length == 0)
        {
            return 0;
        }
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1); //initially fill result[] with 1s
        //left pass
        for(int i = 1; i < ratings.length; i++)
        {
            //check if a child has higher rating than its left neighbour, if so increase candy
            if(ratings[i] > ratings[i - 1])
            {
                result[i] = result[i - 1] + 1;
            }
        }
        //right pass
        for(int i = ratings.length - 2; i >= 0; i--)
        {
            //check if a child has high rating than its right neighbour and has lower candy, then increase candy
            if(ratings[i] > ratings[i + 1] && result[i] <= result[i + 1])
            {
                result[i] = result[i + 1] + 1;
            }
        }
        
        int answer = 0;
        for(int r : result)
        {
            answer += r;
        }
        return answer;
    }
}
