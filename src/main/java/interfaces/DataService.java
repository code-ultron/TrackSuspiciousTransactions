package interfaces;

import java.util.List;

public interface DataService<T> {
	
	public void addSingleRecord(T record);
	public void addBulkRecords(List<T> records);

}
