DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE application (
    App_code UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    Name VARCHAR(200) NOT NULL,
    App_group VARCHAR(200) NOT NULL,
    App_type VARCHAR(200) NOT NULL,
    Description VARCHAR(20000) NOT NULL,
    App_cost DECIMAL(15, 2) NOT NULL CHECK (App_cost >= 0.00),
    Last_modified TIMESTAMP NOT NULL
);

CREATE TABLE app_service (
    App_code UUID,
    Service_code UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    Name VARCHAR(200) NOT NULL,
    Type VARCHAR(200) NOT NULL CHECK (Type IN ('HTTP', 'SAML', 'SSH', 'JDBC', 'ODBC')),
    Sub_type VARCHAR(200) NOT NULL CHECK (Sub_type IN ('REST', 'SOAP')),
    Description VARCHAR(20000) NOT NULL,
    Last_modified TIMESTAMP NOT NULL,
    FOREIGN KEY (App_code) REFERENCES application (App_code) ON DELETE CASCADE
);
