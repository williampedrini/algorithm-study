package com.custodio.study.codility;

import java.util.*;
import java.util.Map.Entry;

import static java.lang.Long.parseLong;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.*;

/**
 * @see <a href="https://app.codility.com/c/run/6CJWWS-M9Q/">Codility</a>
 */
public class VisitCounter {

    /**
     * @param visits List of maps containing the total number of visit per user.
     * @return Number of visits by user identifier.
     */
    public Map<Long, Long> count(final Map<String, UserStats>... visits) {
        return ofNullable(visits)
                .map(Arrays::asList)
                .orElseGet(ArrayList::new)
                .stream()
                .filter(Objects::nonNull)
                .filter(visitByUserIDs -> !visitByUserIDs.isEmpty())
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .filter(this::isValidIdentifier)
                .filter(visitByUserID -> nonNull(visitByUserID.getValue()))
                .filter(visitByUserID -> visitByUserID.getValue().getVisitCount().isPresent())
                .collect(groupingBy(visitByUserID -> parseLong(visitByUserID.getKey()), collectingAndThen(toList(), counters ->
                        counters.stream()
                                .mapToLong(counter -> counter.getValue().getVisitCount().orElse(0L))
                                .sum()
                )));
    }

    private boolean isValidIdentifier(final Entry<String, UserStats> visitByUserID) {
        try {
            parseLong(visitByUserID.getKey());
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private record UserStats(Long visitCount) {
        public Optional<Long> getVisitCount() {
            return ofNullable(visitCount);
        }
    }
}
