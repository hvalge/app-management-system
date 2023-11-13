DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE application (
    App_code UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    Name VARCHAR(200) NOT NULL,
    App_group VARCHAR(200) NOT NULL CHECK (App_group IN ('USER_INTERFACE', 'BUSINESS_LOGIC', 'DATABASE')),
    App_type VARCHAR(200) NOT NULL CHECK (App_type IN ('VUE', 'JAVA', 'POSTGRESQL')),
    Description VARCHAR(20000) NOT NULL,
    App_cost DECIMAL NOT NULL,
    Last_modified TIMESTAMP NOT NULL
);

CREATE TABLE app_service (
    App_code UUID,
    Service_code UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    Name VARCHAR NOT NULL,
    Type VARCHAR NOT NULL CHECK (Type IN ('HTTP', 'SAML', 'SSH', 'JDBC', 'ODBC')),
    Sub_type VARCHAR NOT NULL CHECK (Sub_type IN ('REST', 'SOAP')),
    Description VARCHAR(20000) NOT NULL,
    Last_modified TIMESTAMP NOT NULL,
    FOREIGN KEY (App_code) REFERENCES application (App_code) ON DELETE CASCADE
);
