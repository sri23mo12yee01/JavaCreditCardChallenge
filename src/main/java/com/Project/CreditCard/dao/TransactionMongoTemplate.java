package com.Project.CreditCard.dao;

import com.Project.CreditCard.dto.*;
import com.Project.CreditCard.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
@Repository

public class TransactionMongoTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Transaction> getAllTransactions() {
        return mongoTemplate.findAll(Transaction.class);
    }
    public Transaction getTransactionById(String transID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(transID));
        return mongoTemplate.findOne(query, Transaction.class);
    }


    public List<SpendingByGender> getSpendingHistoryByGender() {

        GroupOperation groupByGender = group("gender").sum("amt")
                .as("total_amount");

        MatchOperation allGenderCategory = match(new Criteria("gender").exists(true));

        ProjectionOperation includes = project("total_amount").and("gender").previousOperation();

        SortOperation sortByGender = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allGenderCategory,groupByGender,sortByGender,includes);
        AggregationResults<SpendingByGender> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByGender.class);
        List<SpendingByGender> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByCategory> getSpendingHistoryByCategory() {
        System.out.println("In DAO");
        GroupOperation groupByCategory = group("category").sum("amt")
                .as("total_amount");
        System.out.println("Grouping by category and aggregation on sum of amount");
        MatchOperation allCategories = match(new Criteria("category").exists(true));
        System.out.println("Match operation created");
        ProjectionOperation includes = project("total_amount").and("category").previousOperation();
        System.out.println("Projection operation created");

        SortOperation sortByCategory = sort(Sort.by(Sort.Direction.DESC,"total_amount"));
        System.out.println("Sort operation created");

        Aggregation aggregation = newAggregation(allCategories,groupByCategory,sortByCategory,includes);
        AggregationResults<SpendingByCategory> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByCategory.class);
        System.out.println("Aggregation operation created");

        List<SpendingByCategory> result = groupResults.getMappedResults();
        //System.out.println(result);
        return result;
    }

    public List<SpendingByMerchant> getSpendingHistoryByMerchant() {

        GroupOperation groupByMerchant = group("merchant").sum("amt")
                .as("total_amount");

        MatchOperation allMerchants = match(new Criteria("merchant").exists(true));

        ProjectionOperation includes = project("total_amount").and("merchant").previousOperation();

        SortOperation sortByMerchant = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allMerchants,groupByMerchant,sortByMerchant,includes);
        AggregationResults<SpendingByMerchant> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByMerchant.class);
        List<SpendingByMerchant> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByCity> getSpendingHistoryByCity() {

        GroupOperation groupByCity = group("city").sum("amt")
                .as("total_amount");

        MatchOperation allCities = match(new Criteria("city").exists(true));

        ProjectionOperation includes = project("total_amount").and("city").previousOperation();

        SortOperation sortByCity = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allCities,groupByCity,sortByCity,includes);
        AggregationResults<SpendingByCity> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByCity.class);
        List<SpendingByCity> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByState> getSpendingHistoryByState() {

        GroupOperation groupByState = group("state").sum("amt")
                .as("total_amount");

        MatchOperation allStates = match(new Criteria("state").exists(true));

        ProjectionOperation includes = project("total_amount").and("state").previousOperation();

        SortOperation sortByState = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allStates,groupByState,sortByState,includes);
        AggregationResults<SpendingByState> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByState.class);
        List<SpendingByState> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByProfession> getSpendingHistoryByProfession() {

        GroupOperation groupByJob = group("Job").sum("amt")
                .as("total_amount");

        MatchOperation allJobs = match(new Criteria("Job").exists(true));

        ProjectionOperation includes = project("total_amount").and("Job").previousOperation();

        SortOperation sortByJob = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allJobs,groupByJob,sortByJob,includes);
        AggregationResults<SpendingByProfession> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByProfession.class);
        List<SpendingByProfession> result = groupResults.getMappedResults();
        return result;
    }

    public List<Transaction> getLowValueTransactions() {
        MatchOperation matchLowValue = Aggregation.match(Criteria.where("amt").lte(100));
        SortOperation sortByAmount = Aggregation.sort(Sort.by("amt"));

        Aggregation aggregation = Aggregation.newAggregation(matchLowValue, sortByAmount);

        return mongoTemplate.aggregate(aggregation, "transactions", Transaction.class).getMappedResults();
    }

    public List<Transaction> getHighValueTransactions() {
        MatchOperation matchHighValue = Aggregation.match(Criteria.where("amt").gt(100)); // Adjust the threshold as needed
        SortOperation sortByAmountDescending = Aggregation.sort(Sort.by(Sort.Direction.DESC, "amt"));

        Aggregation aggregation = Aggregation.newAggregation(matchHighValue, sortByAmountDescending);

        return mongoTemplate.aggregate(aggregation, "transactions", Transaction.class).getMappedResults();
    }


}
