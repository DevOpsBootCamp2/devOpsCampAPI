package comp.cap.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.cap.domain.User;

import comp.cap.util.Encryption;

public class UserDAODynamoDB implements UserDAO {

	private AmazonDynamoDB dynamoDB = null;
	private final String tableName = "user";
	private final Regions region = Regions.EU_WEST_1;
	private final AWSCredentialsProvider credentials = new ProfileCredentialsProvider("default");

	private final String firstName = "FirstName";
	private final String lastName = "LastName";
	private final String email = "email";
	private final String password = "password";

	public UserDAODynamoDB() {
		dynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion(region).withCredentials(new InstanceProfileCredentialsProvider(false)).build();
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		
		ScanRequest scanRequest = new ScanRequest(tableName);
		ScanResult scanResult = dynamoDB.scan(scanRequest);
		System.out.println("users Result: " + scanResult);
		for(Map<String, AttributeValue> userMap : scanResult.getItems()){
			users.add(new User(userMap.get(this.firstName).getS(), userMap.get(this.lastName).getS(),
					userMap.get(this.password).getS(), userMap.get(this.email).getS()));
		}
		
		return users;
	}
	
	@Override
	public User getUser(String email) {
		User user = null;
		HashMap<String, Condition> scanFilter = new HashMap<String, Condition>();
		Condition condition = new Condition().withComparisonOperator(ComparisonOperator.EQ)
				.withAttributeValueList(new AttributeValue().withS(email));
		scanFilter.put(this.email, condition);
		ScanRequest scanRequest = new ScanRequest(tableName).withScanFilter(scanFilter);
		ScanResult scanResult = dynamoDB.scan(scanRequest);

		if (scanResult.getCount() == 1) {
			Map<String, AttributeValue> userMap = scanResult.getItems().get(0);
			user = new User(userMap.get(this.firstName).getS(), userMap.get(this.lastName).getS(),
					userMap.get(this.password).getS(), userMap.get(this.email).getS());
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteUSer(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUser(User user) {
		Map<String, AttributeValue> item = createUserItem(user);
		PutItemRequest putItemRequest = new PutItemRequest(tableName, item);
		PutItemResult putItemResult = dynamoDB.putItem(putItemRequest);
		System.out.println("putItemResult : " + putItemResult);
	}

	private Map<String, AttributeValue> createUserItem(User user) {
		Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
		item.put(this.firstName, new AttributeValue(user.getFirstName()));
		item.put(this.lastName, new AttributeValue(user.getLastName()));
		item.put(this.email, new AttributeValue(user.getEmail()));
		item.put(this.password, new AttributeValue(Encryption.cryptWithMD5(user.getPassword())));
		return item;
	}

}
