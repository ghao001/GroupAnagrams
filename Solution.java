import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        List<String> keyList=new ArrayList<>();
        for(int i=0;i<strs.length;i++)
        {
            String key=stringToKey(strs[i]);
            if(map.containsKey(key))
                map.get(key).add(strs[i]);
            else
            {
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
                keyList.add(key);
            }
        }
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<keyList.size();i++)
            result.add(map.get(keyList.get(i)));
        return result;
        
    }
    private String stringToKey(String in)
    {
        for(int i=1;i<in.length();i++)
        {
            for(int j=0;j<in.length()-i;j++)
            {
                if(in.charAt(j)>in.charAt(j+1))
                {
                    if(j==0)
                        in=in.substring(1,2)+in.substring(0,1)+in.substring(2);
                    else 
                        if(j==in.length()-1)
                            in=in.substring(0,j)+in.substring(j+1,j+2)+in.substring(j,j+1);    
                        else in=in.substring(0,j)+in.substring(j+1,j+2)+in.substring(j,j+1)+in.substring(j+2);
                }
            }
        }
        return in;
    }
}
