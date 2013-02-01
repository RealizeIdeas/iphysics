databaseChangeLog = {

    changeSet(author: "ami (generated)", id: "1359755923884-1") {
        createTable(tableName: "answer") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "answerPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "datetime")

            column(name: "is_correct", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime")

            column(name: "value", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-2") {
        createTable(tableName: "category") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "categoryPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "datetime")

            column(name: "description", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime")

            column(name: "title", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-3") {
        createTable(tableName: "exam") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "examPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "datetime")

            column(name: "last_updated", type: "datetime")

            column(name: "student_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-4") {
        createTable(tableName: "exam_question") {
            column(name: "exam_questions_id", type: "bigint")

            column(name: "question_id", type: "bigint")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-5") {
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

            column(name: "date_created", type: "datetime")

            column(name: "description", type: "varchar(255)")

            column(name: "last_updated", type: "datetime")

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

    changeSet(author: "ami (generated)", id: "1359755923884-6") {
        createTable(tableName: "question_answer") {
            column(name: "question_answers_id", type: "bigint")

            column(name: "answer_id", type: "bigint")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-7") {
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

    changeSet(author: "ami (generated)", id: "1359755923884-8") {
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

    changeSet(author: "ami (generated)", id: "1359755923884-9") {
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

    changeSet(author: "ami (generated)", id: "1359755923884-10") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)")

            column(name: "date_created", type: "datetime")

            column(name: "email", type: "varchar(255)")

            column(name: "enabled", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime")

            column(name: "password", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "total_points", type: "decimal(19,2)")

            column(name: "username", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-11") {
        createTable(tableName: "user_role") {
            column(name: "role_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-12") {
        addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-25") {
        createIndex(indexName: "FK2FB81F121F49E3", tableName: "exam") {
            column(name: "student_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-26") {
        createIndex(indexName: "FKE2CB68067B71ED69", tableName: "exam_question") {
            column(name: "question_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-27") {
        createIndex(indexName: "FKE2CB6806A8347D62", tableName: "exam_question") {
            column(name: "exam_questions_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-28") {
        createIndex(indexName: "FKBA823BE6E6213669", tableName: "question") {
            column(name: "category_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-29") {
        createIndex(indexName: "FK561DF2373CD3CE29", tableName: "question_answer") {
            column(name: "answer_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-30") {
        createIndex(indexName: "FK561DF2379709C073", tableName: "question_answer") {
            column(name: "question_answers_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-31") {
        createIndex(indexName: "url_uniq_1359755923769", tableName: "requestmap", unique: "true") {
            column(name: "url")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-32") {
        createIndex(indexName: "authority_uniq_1359755923772", tableName: "role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-33") {
        createIndex(indexName: "FKAD2AD242121F49E3", tableName: "student_answer") {
            column(name: "student_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-34") {
        createIndex(indexName: "FKAD2AD24219F7A130", tableName: "student_answer") {
            column(name: "exam_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-35") {
        createIndex(indexName: "FKAD2AD2423CD3CE29", tableName: "student_answer") {
            column(name: "answer_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-36") {
        createIndex(indexName: "FKAD2AD2427B71ED69", tableName: "student_answer") {
            column(name: "question_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-37") {
        createIndex(indexName: "username_uniq_1359755923780", tableName: "user", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-38") {
        createIndex(indexName: "FK143BF46A46E3B653", tableName: "user_role") {
            column(name: "user_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-39") {
        createIndex(indexName: "FK143BF46AA1B8F273", tableName: "user_role") {
            column(name: "role_id")
        }
    }

    changeSet(author: "ami (generated)", id: "1359755923884-13") {
        addForeignKeyConstraint(baseColumnNames: "student_id", baseTableName: "exam", constraintName: "FK2FB81F121F49E3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-14") {
        addForeignKeyConstraint(baseColumnNames: "exam_questions_id", baseTableName: "exam_question", constraintName: "FKE2CB6806A8347D62", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "exam", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-15") {
        addForeignKeyConstraint(baseColumnNames: "question_id", baseTableName: "exam_question", constraintName: "FKE2CB68067B71ED69", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "question", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-16") {
        addForeignKeyConstraint(baseColumnNames: "category_id", baseTableName: "question", constraintName: "FKBA823BE6E6213669", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "category", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-17") {
        addForeignKeyConstraint(baseColumnNames: "answer_id", baseTableName: "question_answer", constraintName: "FK561DF2373CD3CE29", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "answer", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-18") {
        addForeignKeyConstraint(baseColumnNames: "question_answers_id", baseTableName: "question_answer", constraintName: "FK561DF2379709C073", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "question", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-19") {
        addForeignKeyConstraint(baseColumnNames: "answer_id", baseTableName: "student_answer", constraintName: "FKAD2AD2423CD3CE29", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "answer", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-20") {
        addForeignKeyConstraint(baseColumnNames: "exam_id", baseTableName: "student_answer", constraintName: "FKAD2AD24219F7A130", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "exam", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-21") {
        addForeignKeyConstraint(baseColumnNames: "question_id", baseTableName: "student_answer", constraintName: "FKAD2AD2427B71ED69", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "question", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-22") {
        addForeignKeyConstraint(baseColumnNames: "student_id", baseTableName: "student_answer", constraintName: "FKAD2AD242121F49E3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-23") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46AA1B8F273", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
    }

    changeSet(author: "ami (generated)", id: "1359755923884-24") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A46E3B653", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }
}
