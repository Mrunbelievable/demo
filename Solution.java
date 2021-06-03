import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public List<FeedItem> reorderFeedItems(List<FeedItem> inputItems){
        List<FeedItem> results = new ArrayList<>();
        HashSet<Integer> used = new HashSet<>();
        results.add(inputItems.get(0));  // 第一条总是没有任何限制的
        used.add(0);

        while(results.size() < 10){     // 要求inputItems 数量大于等于10
            FeedItem previousItem = results.get(results.size()-1);
            HashSet<Integer> tmp = new HashSet<>();

            while(true){
                int firstNotSameAuthor = -1;
                for (int i = 0; i < inputItems.size(); i++) {
                    if(used.contains(i)){
                        continue;
                    }

                    if(tmp.contains(i)){
                        continue;
                    }

                    if(!previousItem.getAuthor().equals(inputItems.get(i).getAuthor())){
                        firstNotSameAuthor = i; // 找到第一个不是相同作者的序号
                        break;
                    }
                }

                if(firstNotSameAuthor == -1){ // 实在是没有符合要求的了，按照原定顺序
                    int best = -1;
                    for (int i = 0; i < inputItems.size(); i++) {
                        if(used.contains(i)){
                            continue;
                        }

                        if(!previousItem.getAuthor().equals(inputItems.get(i).getAuthor())){
                            best = i; // 找到第一个不是相同作者的序号
                            break;
                        }
                    }

                    if(best == -1){
                        for (int i = 0; i < inputItems.size(); i++) {
                            if(used.contains(i)){
                                continue;
                            }

                            best = i;
                            break;
                        }
                    }

                    results.add(inputItems.get(best));
                    used.add(best);

                    break;
                }else{
                    if(differentCategory(results, inputItems.get(firstNotSameAuthor))){
                        results.add(inputItems.get(firstNotSameAuthor));
                        used.add(firstNotSameAuthor);
                        break;
                    }
                }



                // 如果当前目录和前面两个相同，那么继续往后找
                tmp.add(firstNotSameAuthor);
            }
        }
        return results;
    }

    private boolean differentCategory(List<FeedItem> results, FeedItem feedItem) {  // 判断是不是和前面是同一个category
        if(results.size() < 2){
            return true;
        }

        return !(results.get(results.size()-1).getCategory().equals(feedItem.getCategory()) &&
                results.get(results.size()-2).getCategory().equals(feedItem.getCategory()));
    }


}
