package app_prosjekt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ScreenplayComparator implements Comparator<Screenplay>{
    private String sortBy;
    private final List<String> validSort = Arrays.asList("Type","Year","Rating");

    public ScreenplayComparator(String sortBy) {
        if (!validSort.contains(sortBy)) {
            throw new IllegalArgumentException("Ugyldig sorteringsmetode");
        }
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Screenplay s1, Screenplay s2) {
            if (sortBy.equals("Type")) {
                if (s1.getType().equals("Movie")){
                    if (s2.getType().equals("Movie")){
                        return 0;
                    } 
                    return -1;
                }
                else if (s1.getType().equals("Show")){
                        if (s2.getType().equals("Show")){
                            return 1;
                        }
                        return 2;
                    }
                else {
                    throw new IllegalArgumentException("Ingen andre muligheter");
                }
            }
         
            else if (sortBy.equals("Year")){
                return s1.getYear() - s2.getYear();
            }
           
            else if (sortBy.equals("Rating")){
                return Integer.compare((int)(s2.getRating()*100), (int)(s1.getRating()*100));
                }
                
            else {
                throw new IllegalArgumentException("Du kan ikke sortere etter dette");
                }
            }
        }
    
    
