databaseChangeLog = {

    changeSet(author: "ami (generated)", id: "1358096382226-1") {
        createTable(tableName: "answer") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "answerPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "timestamp")

            column(name: "is_correct", type: "boolean") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "timestamp")

            column(name: "value", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-2") {
        createTable(tableName: "category") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "categoryPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "timestamp")

            column(name: "description", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "timestamp")

            column(name: "title", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-3") {
        createTable(tableName: "exam") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "examPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "timestamp")

            column(name: "last_updated", type: "timestamp")

            column(name: "student_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-4") {
        createTable(tableName: "question") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "questionPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "category_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "timestamp")

            column(name: "description", type: "varchar(255)")

            column(name: "last_updated", type: "timestamp")

            column(name: "max_points_to_earn", type: "decimal(19,2)") {
                constraints(nullable: "false")
            }

            column(name: "title", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "type", type: "varchar(10)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-5") {
        createTable(tableName: "question_answer") {
            column(name: "question_asnwers_id", type: "bigint")

            column(name: "answer_id", type: "bigint")
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-6") {
        createTable(tableName: "requestmap") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "requestmapPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "config_attribute", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "url", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-7") {
        createTable(tableName: "role") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-8") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "boolean") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "boolean") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "timestamp")

            column(name: "email", type: "varchar(255)")

            column(name: "enabled", type: "boolean") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "timestamp")

            column(name: "password", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "boolean") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-9") {
        createTable(tableName: "user_role") {
            column(name: "role_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-10") {
        addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "ami (generated)", id: "1358096382226-11") {
        addForeignKeyConstraint(baseColumnNames: "student_id", baseTableName: "exam", constraintName: "FK2FB81F121F49E3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358096382226-12") {
        addForeignKeyConstraint(baseColumnNames: "category_id", baseTableName: "question", constraintName: "FKBA823BE6E6213669", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "category", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358096382226-13") {
        addForeignKeyConstraint(baseColumnNames: "answer_id", baseTableName: "question_answer", constraintName: "FK561DF2373CD3CE29", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "answer", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358096382226-14") {
        addForeignKeyConstraint(baseColumnNames: "question_asnwers_id", baseTableName: "question_answer", constraintName: "FK561DF23774FA0B1D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "question", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358096382226-15") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46AA1B8F273", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358096382226-16") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A46E3B653", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358096382226-17") {
        createIndex(indexName: "url_unique_1358096382133", tableName: "requestmap", unique: "true") {
            column(name: "url")
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-18") {
        createIndex(indexName: "authority_unique_1358096382136", tableName: "role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "ami (generated)", id: "1358096382226-19") {
        createIndex(indexName: "username_unique_1358096382141", tableName: "user", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "ami (generated)", id: "1358193606911-1") {
        createTable(tableName: "exam_question") {
            column(name: "exam_questions_id", type: "bigint")

            column(name: "question_id", type: "bigint")
        }
    }

    changeSet(author: "ami (generated)", id: "1358193606911-2") {
        createTable(tableName: "student_answer") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "student_answePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "answer_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "datetime")

            column(name: "exam_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime")

            column(name: "question_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "student_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1358193606911-3") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "date_created", tableName: "answer")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-4") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "last_updated", tableName: "answer")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-5") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "date_created", tableName: "category")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-6") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "last_updated", tableName: "category")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-7") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "date_created", tableName: "exam")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-8") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "last_updated", tableName: "exam")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-9") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "date_created", tableName: "question")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-10") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "last_updated", tableName: "question")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-11") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "date_created", tableName: "user")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-12") {
        dropNotNullConstraint(columnDataType: "datetime", columnName: "last_updated", tableName: "user")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-13") {
        addForeignKeyConstraint(baseColumnNames: "exam_questions_id", baseTableName: "exam_question", constraintName: "FKE2CB6806A8347D62", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "exam", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-14") {
        addForeignKeyConstraint(baseColumnNames: "question_id", baseTableName: "exam_question", constraintName: "FKE2CB68067B71ED69", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "question", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-15") {
        addForeignKeyConstraint(baseColumnNames: "answer_id", baseTableName: "student_answer", constraintName: "FKAD2AD2423CD3CE29", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "answer", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-16") {
        addForeignKeyConstraint(baseColumnNames: "exam_id", baseTableName: "student_answer", constraintName: "FKAD2AD24219F7A130", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "exam", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-17") {
        addForeignKeyConstraint(baseColumnNames: "question_id", baseTableName: "student_answer", constraintName: "FKAD2AD2427B71ED69", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "question", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-18") {
        addForeignKeyConstraint(baseColumnNames: "student_id", baseTableName: "student_answer", constraintName: "FKAD2AD242121F49E3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358193606911-19") {
        createIndex(indexName: "FKE2CB68067B71ED69", tableName: "exam_question") {
            column(name: "question_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1358193606911-20") {
        createIndex(indexName: "FKE2CB6806A8347D62", tableName: "exam_question") {
            column(name: "exam_questions_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1358193606911-21") {
        createIndex(indexName: "FKAD2AD242121F49E3", tableName: "student_answer") {
            column(name: "student_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1358193606911-22") {
        createIndex(indexName: "FKAD2AD24219F7A130", tableName: "student_answer") {
            column(name: "exam_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1358193606911-23") {
        createIndex(indexName: "FKAD2AD2423CD3CE29", tableName: "student_answer") {
            column(name: "answer_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1358193606911-24") {
        createIndex(indexName: "FKAD2AD2427B71ED69", tableName: "student_answer") {
            column(name: "question_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1358193606911-25") {
        createIndex(indexName: "FK143BF46AA1B8F273", tableName: "user_role") {
            column(name: "role_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1358287544539-1") {
        addColumn(tableName: "question_answer") {
            column(name: "question_answers_id", type: "bigint")
        }
    }

    changeSet(author: "ami (generated)", id: "1358287544539-2") {
        addColumn(tableName: "user") {
            column(name: "total_points", type: "decimal(19,2)")
        }
    }

    changeSet(author: "ami (generated)", id: "1358287544539-3") {
        dropForeignKeyConstraint(baseTableName: "question_answer", baseTableSchemaName: "iphysics", constraintName: "FK561DF23774FA0B1D")
    }

    changeSet(author: "ami (generated)", id: "1358287544539-4") {
        addForeignKeyConstraint(baseColumnNames: "question_answers_id", baseTableName: "question_answer", constraintName: "FK561DF2379709C073", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "question", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1358287544539-5") {
        createIndex(indexName: "FK561DF2379709C073", tableName: "question_answer") {
            column(name: "question_answers_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1358287544539-6") {
        dropColumn(columnName: "question_asnwers_id", tableName: "question_answer")
    }
}
