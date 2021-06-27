package com.company;
import java.util.*;

public class TravelBuddy {


    class Buddy implements Comparable<Buddy>{
        int similarity;
        Set<String> cityList;
        String name;

        public Buddy(int similarity, String name, Set<String> cityList) {
            this.similarity = similarity;
            this.name = name;
            this.cityList = cityList;
        }

        @Override
        public int compareTo(Buddy that) {
            return that.similarity - this.similarity;
        }
    }
    List<Buddy> buddies;
    Set<String> myWishList;

    public TravelBuddy(Set<String> myWishList, Map<String, Set<String>> friendsWishList) {
        // a list of buddy
        this.buddies = new ArrayList<>();
        this.myWishList = myWishList;
        for(String friendName: friendsWishList.keySet()) {
            Set<String> friendCities = friendsWishList.get(friendName);

            Set<String> common = new HashSet<>(friendCities);
            common.retainAll(myWishList);

            if(common.size()>=friendCities.size()/2) {
                this.buddies.add(new Buddy(common.size(), friendName, friendCities));
            }
        }
        Collections.sort(this.buddies);

    }

    public List<String> getRecommendedCities(int k) {
        List<String> result = new ArrayList<>();

        int st = 0;

        while(k>0 && st < this.buddies.size()) {
            Set<String> curCities = this.buddies.get(st).cityList;
            curCities.removeAll(this.myWishList);

            if(curCities.size() <=k) {
                result.addAll(curCities);
                k -= curCities.size();
                st +=1;
            } else {

                List<String> tmp = new ArrayList<>(curCities);
                int subSt = 0;
                while(k>0 && st < this.buddies.size()) {
                    result.add(tmp.get(subSt++));
                    if(subSt>=tmp.size()) {
                        subSt = 0;
                        st+=1;
                    }
                    k-=1;
                }
            }
        }
        return result;
    }
}
