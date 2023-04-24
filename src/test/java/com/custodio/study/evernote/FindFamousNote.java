package com.custodio.study.evernote;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/*
  ** Coding problem **

  Given a set of notes, find any and all famous notes

  Definitions:

  interface Note {
    // Returns true if this note links to n2. This is a unidirectional relationship
    boolean linksTo(Note n2);
  }

  A note f is famous in a set of notes N iff:
      1. f.linksTo(n) == false   ; n ∈ N, n != f
      2. n.linksTo(f) == true    ; n ∈ N, n != f

  or in plain English: Find any notes f in a set of notes N where
      1. f does not link to any other notes
      2. All other notes link to f

  Note famous = findFamous(List<Note> notes);
     Note == NULL  ==> no famous note there
     Note != NULL  ==> the famous note

  For testing:

  Suppose Note(id, linkedNotesIds)

  notes = [
      new Note(1, [2, 3, 4]),
      new Note(2, []),
      new Note(3, [1, 2]),
      new Note(4, [2]),
    ]; ==> Note(2) is famous

  notes = [
      new Note(1, [2, 3, 4]),
      new Note(2, [1]),
      new Note(3, [1, 3]),
      new Note(4, [1]),
  ]; ==> No famous note here
*/
public class FindFamousNote {

    @Test
    public void example1() {
        //given
        final var notes = asList(
                new Note(1, new Integer[]{2, 3, 4}),
                new Note(2, new Integer[]{}),
                new Note(3, new Integer[]{1, 2}),
                new Note(4, new Integer[]{2})
        );
        //when
        final var actual = solution(notes);
        //then
        final var expected = new Note(2, new Integer[]{});
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var notes = asList(
                new Note(1, new Integer[]{2, 3, 4}),
                new Note(2, new Integer[]{1}),
                new Note(3, new Integer[]{1, 3}),
                new Note(4, new Integer[]{1})
        );
        //when
        final var actual = solution(notes);
        //then
        assertNull(actual);
    }

    private Note solution(final Collection<Note> notes) {
        final var result = new HashMap<Integer, Integer>();
        for (var note : notes) {
            for (var linkedNote : note.references) {
                if (linkedNote.references.isEmpty()) {
                    final var quantity = result.getOrDefault(linkedNote.id, 0);
                    result.put(linkedNote.id, quantity + 1);
                }
            }
        }

        final var id = result
                .entrySet()
                .stream()
                .filter(entry -> {
                    final var quantity = entry.getValue();
                    return quantity == notes.size() - 1;
                })
                .map(Map.Entry::getKey)
                .findAny()
                .orElse(null);

        return notes.stream()
                .filter(note -> Objects.equals(note.id, id))
                .findAny()
                .orElse(null);
    }

    private static class Note {
        private final Integer id;
        private final Collection<Note> references;

        private Note(final int id, final Collection<Note> references) {
            this.id = id;
            this.references = references;
        }

        private Note(final int id) {
            this(id, emptyList());
        }

        private Note(final int id, final Integer[] references) {
            this(id, stream(references).map(Note::new).collect(toList()));
        }

        @Override
        public String toString() {
            final var template = "{id: %d, nodes: [%s]}";
            return format(template, id, references
                    .stream()
                    .map(note -> note.id)
                    .map(Object::toString)
                    .collect(joining(",")));
        }
    }
}
