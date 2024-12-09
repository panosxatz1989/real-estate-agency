-- ****************************************************************** --

INSERT INTO
    permissions (`id`, `resource`, `action`)
VALUES

    (1, 'User', 'View'), (2, 'User', 'Create'), (3, 'User', 'Delete'), (4, 'User', 'Update'),
    (5, 'Agent', 'View'), (6, 'Agent', 'Create'), (7, 'Agent', 'Delete'), (8, 'Agent', 'Update'),
    (9, 'Property', 'View'), (10, 'Property', 'Create'), (11, 'Property', 'Delete'), (12, 'Property', 'Update'),
    (13, 'Role', 'View'), (14, 'Permission', 'View'), (15, 'Property_Type', 'View'),
    (16, 'Inquiry', 'View'), (17, 'Inquiry', 'Create'), (18, 'Inquiry', 'Delete'), (19, 'Inquiry', 'Update');

-- ****************************************************************** --

INSERT INTO
    roles (`id`, `title`, `machine_name`)
VALUES
    (1, 'Administrator', 'admin'), (2, 'Guest', 'guest'),
    (3, 'Agent', 'agent'), (4, 'User', 'user');

-- ****************************************************************** --

INSERT INTO
    roles_permissions (`role_id`, `permission_id`)
VALUES
    (1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
    (2, 2), (3, 2), (3, 3), (3, 4), (3, 5),
    (4, 2), (4, 1);

-- ****************************************************************** --

INSERT INTO
    property_types (`type`)
VALUES
    ('Διαμέρισμα'), ('Μονοκατοικία'), ('Γεωτεμάχιο'),
    ('Οικόπεδο'), ('Επαγγελματικός Χώρος');

-- ****************************************************************** --

--INSERT INTO
--    floors (`id`, `number`, `name`)
--VALUES
--    (1, -2, 'Ημιυπόγειο'),
--    (2, -1, 'Ισόγειο'),
--    (3, 0, 'Ημιόροφος'),
--    (4, 1, '1ος Όροφος'),
--    (5, 2, '2ος Όροφος'),
--    (6, 3, '3ος Όροφος'),
--    (7, 4, '4ος Όροφος'),
--    (8, 5, '5ος Όροφος');

-- ****************************************************************** --

INSERT INTO
    regions (`id`, `title`)
VALUES
    (1, 'Αττική'),
    (2, 'Θεσσαλονίκη'),
    (3, 'Θεσσαλία'),
    (4, 'Στερεά Ελλάδα'),
    (5, 'Πελοπόννησος'),
    (6, 'Κρήτη');

-- ****************************************************************** --

INSERT INTO
    cities (`id`, `title`, `region_id`)
VALUES
    (1, 'Νέα Φιλαδέλφεια', 1),
    (2, 'Νέα Χαλκηδόνα', 1),
    (3, 'Νέα Σμύρνη', 1),
    (4, 'Ίλιον', 1),
    (5, 'Θεσσαλονίκη', 2),
    (6, 'Καλαμαριά', 2),
    (7, 'Λάρισα', 3),
    (8, 'Βόλος', 3),
    (9, 'Λαμία', 4),
    (10, 'Τρίπολη', 5),
    (11, 'Καλαμάτα', 5),
    (12, 'Ηράκλειο Κρήτης', 6),
    (13, 'Χανιά', 6);

-- ****************************************************************** --

INSERT INTO
    attributes (`id`, `title`, `machine_name`, `metric_unit`, `has_restricted_values`)
VALUES
    (1, 'Όροφος', 'floor', NULL, FALSE),
    (2, 'Υπνοδωμάτια', 'bedrooms', NULL, FALSE),
    (3, 'Μέσα θέρμανσης', 'heating_methods', NULL, TRUE),
    (4, 'Εμβαδό', 'area', 'τμ', FALSE),
    (5, 'Έτος Κατασκευής', 'constructed_at', NULL, FALSE),
    (6, 'Μπάνια', 'bathrooms', NULL, FALSE),
    (7, 'Parking', 'parking', NULL, TRUE);


-- ****************************************************************** --

INSERT INTO
    attribute_possible_values (`id`, `attribute_id`, `possible_value`)
VALUES
    (1, 1, '0'), (2, 1, '1'), (3, 1, '2'), (4, 1, '3'), (5, 1, '4'),
    (6, 1, '5'), (7, 3, 'Καλοριφέρ'), (8, 3, 'Air Condition'), (9, 3, 'Τζάκι'),
    (10, 7, 'Ναι'), (11, 7, 'Όχι');

-- ****************************************************************** --

INSERT INTO
    property_type_available_attributes (`id`, `property_type_id`, `attribute_id`, `show_in_preview`)
VALUES
    (1, 1, 1, TRUE), (2, 1, 2, TRUE), (3, 1, 3, FALSE), (4, 1, 4, TRUE), (5, 3, 4, TRUE), (6, 4, 4, TRUE);

-- ****************************************************************** --

INSERT INTO
    `users` (`active`, `id`, `role_id`, `phone`, `email`, `username`, `password`)
VALUES
    (TRUE, 1, 4, '6972012873', 'panosmonma@gmail.com', 'panosxatz1989', '$2a$10$LoPDvN3IAecFX/MRTqLOvOPwRiTI8DTBC6iYW50haeTHmwKf7EhKy'),
    (TRUE, 2, 1, '6972012873', 'panosmonma@gmail.gr', 'panosxatz', '$2a$10$LoPDvN3IAecFX/MRTqLOvOPwRiTI8DTBC6iYW50haeTHmwKf7EhKy');
