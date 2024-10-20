-- ****************************************************************** --

INSERT INTO
    permissions
VALUES
    (1, 'Auth', 'User', 'View'), (2, 'Listing', 'Property', 'View'),
    (3, 'Listing', 'Property', 'Create'), (4, 'Listing', 'Property', 'Update'),
    (5, 'Listing', 'Property', 'Delete');

-- ****************************************************************** --

INSERT INTO
    roles
VALUES
    (1, 'Administrator', 'admin'), (2, 'Anonymous', 'anonymous'),
    (3, 'Agent', 'agent'), (4, 'User', 'user');

-- ****************************************************************** --

INSERT INTO
    roles_permissions
VALUES
    (1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
    (2, 2), (3, 2), (3, 3), (3, 4), (3, 5),
    (4, 2);

-- ****************************************************************** --

INSERT INTO
    property_types
VALUES
    ('Διαμέρισμα'), ('Μονοκατοικία'), ('Γεωτεμάχιο'),
    ('Οικόπεδο'), ('Επαγγελματικός Χώρος');

-- ****************************************************************** --

INSERT INTO
    floors
VALUES
    (1, -2, 'Ημιυπόγειο'),
    (2, -1, 'Ισόγειο'),
    (3, 0, 'Ημιόροφος'),
    (4, 1, '1ος Όροφος'),
    (5, 2, '2ος Όροφος'),
    (6, 3, '3ος Όροφος'),
    (7, 4, '4ος Όροφος'),
    (8, 5, '5ος Όροφος');

-- ****************************************************************** --

INSERT INTO
    regions
VALUES
    (1, 'Αττική'),
    (2, 'Θεσσαλονίκη'),
    (3, 'Θεσσαλία'),
    (4, 'Στερεά Ελλάδα'),
    (5, 'Πελοπόννησος'),
    (6, 'Κρήτη');

-- ****************************************************************** --

INSERT INTO
    cities
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







