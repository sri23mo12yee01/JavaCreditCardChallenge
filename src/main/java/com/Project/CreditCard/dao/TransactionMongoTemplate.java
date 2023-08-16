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

        GroupOperation groupByGender = group("Gender").sum("Amount")
                .as("total_amount");

        MatchOperation allGenderCategory = match(new Criteria("Gender").exists(true));

        ProjectionOperation includes = project("total_amount").and("Gender").previousOperation();

        SortOperation sortByGender = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allGenderCategory,groupByGender,sortByGender,includes);
        AggregationResults<SpendingByGender> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByGender.class);
        List<SpendingByGender> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByCategory> getSpendingHistoryByCategory() {

        GroupOperation groupByCategory = group("Category").sum("Amount")
                .as("total_amount");

        MatchOperation allCategories = match(new Criteria("Category").exists(true));

        ProjectionOperation includes = project("total_amount").and("Category").previousOperation();

        SortOperation sortByCategory = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allCategories,groupByCategory,sortByCategory,includes);
        AggregationResults<SpendingByCategory> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByCategory.class);
        List<SpendingByCategory> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByMerchant> getSpendingHistoryByMerchant() {

        GroupOperation groupByMerchant = group("Merchant").sum("Amount")
                .as("total_amount");

        MatchOperation allMerchants = match(new Criteria("Merchant").exists(true));

        ProjectionOperation includes = project("total_amount").and("Merchant").previousOperation();

        SortOperation sortByMerchant = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allMerchants,groupByMerchant,sortByMerchant,includes);
        AggregationResults<SpendingByMerchant> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByMerchant.class);
        List<SpendingByMerchant> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByCity> getSpendingHistoryByCity() {

        GroupOperation groupByCity = group("City").sum("Amount")
                .as("total_amount");

        MatchOperation allCities = match(new Criteria("City").exists(true));

        ProjectionOperation includes = project("total_amount").and("City").previousOperation();

        SortOperation sortByCity = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allCities,groupByCity,sortByCity,includes);
        AggregationResults<SpendingByCity> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByCity.class);
        List<SpendingByCity> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByState> getSpendingHistoryByState() {

        GroupOperation groupByState = group("State").sum("Amount")
                .as("total_amount");

        MatchOperation allStates = match(new Criteria("State").exists(true));

        ProjectionOperation includes = project("total_amount").and("State").previousOperation();

        SortOperation sortByState = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allStates,groupByState,sortByState,includes);
        AggregationResults<SpendingByState> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendingByState.class);
        List<SpendingByState> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByProfession> getSpendingHistoryByProfession() {

        GroupOperation groupByJob = group("Job").sum("Amount")
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
        MatchOperation matchLowValue = Aggregation.match(Criteria.where("Amount").lte(100));
        SortOperation sortByAmount = Aggregation.sort(Sort.by("Amount"));

        Aggregation aggregation = Aggregation.newAggregation(matchLowValue, sortByAmount);

        return mongoTemplate.aggregate(aggregation, "transactions", Transaction.class).getMappedResults();
    }

    public List<Transaction> getHighValueTransactions() {
        MatchOperation matchHighValue = Aggregation.match(Criteria.where("Amount").gt(100)); // Adjust the threshold as needed
        SortOperation sortByAmountDescending = Aggregation.sort(Sort.by(Sort.Direction.DESC, "Amount"));

        Aggregation aggregation = Aggregation.newAggregation(matchHighValue, sortByAmountDescending);

        return mongoTemplate.aggregate(aggregation, "transactions", Transaction.class).getMappedResults();
    }


}
