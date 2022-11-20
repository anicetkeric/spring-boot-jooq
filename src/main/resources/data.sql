-- init data
INSERT INTO public.author (id, firstname, lastname)
VALUES (1, 'Bree', 'Nasim'),
       (2, 'Kessie', 'Brenden'),
       (3, 'Willow', 'Kirby'),
       (4, 'Lareina', 'Lunea'),
       (5, 'Flavia', 'Zane'),
       (6, 'Noah', 'Maxwell'),
       (7, 'Kelsey', 'Clinton'),
       (8, 'Gage', 'Marsden'),
       (9, 'Perry', 'Elijah'),
       (10, 'Kennedy', 'Clementine');

ALTER SEQUENCE author_id_seq RESTART WITH 11;

INSERT INTO public.book (id, description, isbn, page, price, title, author_id)
VALUES (1, 'netus et malesuada', 'X4J 5H8', 62, 529, 'arcu. Vestibulum ut', 9),
       (2, 'mollis non,', 'M3Q 4G1', 15, 668, 'Nullam ut', 2),
       (3, 'Maecenas mi felis, adipiscing fringilla, porttitor', 'B5W 1Y8', 16, 708, 'et ipsum cursus', 5),
       (4, 'eros turpis non enim. Mauris quis turpis', 'Q1O 7Y6', 46, 642, 'Nulla tincidunt,', 4),
       (5, 'tellus non magna. Nam ligula elit, pretium', 'Q0V 7Q9', 86, 656, 'purus, in', 1),
       (6, 'a, facilisis non, bibendum sed, est.', 'V6Q 8T2', 57, 299, 'sagittis', 3),
       (7, 'suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum', 'Q2T 8C5', 68, 891,
        'ligula. Donec', 8),
       (8, 'arcu. Vivamus sit amet risus. Donec egestas.', 'R5E 3I4', 14, 455, 'vel', 6),
       (9, 'pede, nonummy ut, molestie in, tempus', 'I0W 6N9', 33, 874, 'lorem semper', 8),
       (10, 'sed consequat auctor, nunc nulla vulputate dui, nec', 'U4E 5V8', 7, 185, 'vel arcu.', 4);

ALTER SEQUENCE book_id_seq RESTART WITH 11;