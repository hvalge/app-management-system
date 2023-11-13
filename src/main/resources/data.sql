INSERT INTO application (App_code, Name, App_group, App_type, Description, App_cost, Last_modified)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Customer Web Portal', 'USER_INTERFACE', 'VUE',
     'Web portal for customer interactions and service requests.', 10000.00, '2023-11-02 11:00:00'),
    ('22222222-2222-2222-2222-222222222222', 'Order Processing System', 'BUSINESS_LOGIC', 'JAVA',
     'Central system for processing and managing customer orders.', 20000.00, '2023-11-01 10:30:00'),
    ('33333333-3333-3333-3333-333333333333', 'Data Storage Solution', 'DATABASE', 'POSTGRESQL',
     'Database system for storing and managing enterprise data.', 15000.00, '2023-11-03 09:45:00');

INSERT INTO app_service (App_code, Name, Type, Sub_type, Description, Last_modified)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'User Authentication Service', 'HTTP', 'REST',
     'A RESTful service for user authentication and session management.', '2023-11-04 12:00:00'),
    ('22222222-2222-2222-2222-222222222222', 'Order Validation Service', 'HTTP', 'SOAP',
     'SOAP service for validating order details and payment information.', '2023-11-05 13:00:00'),
    ('33333333-3333-3333-3333-333333333333', 'Data Backup Service', 'JDBC', 'REST',
     'Service to perform regular data backups and ensure data integrity.', '2023-11-06 14:00:00');