Project Description: Movie Recommendation System

The Movie Recommendation System is a scalable, Java-based backend application designed to manage, query, and process movie data efficiently. It incorporates advanced Java concepts, robust database management, and distributed architecture to support real-world complexities like sharding, caching, and dynamic querying.

Key Features
	1.	Movie Management:
	•	Add, retrieve, and search movies by title, genre, or actor.
	•	Dynamic querying using the Strategy Pattern.
	2.	Sharded Architecture:
	•	Data partitioned into shards for scalability.
	•	Uses ArrayList<HashMap<UserId, ConcurrentLinkedQueue<Movie>>>.
	3.	Caching:
	•	Multi-level caching with ConcurrentHashMap and Redis.
	•	LRU eviction policy for memory optimization.
	4.	AWS Integration:
	•	S3 for data ingestion and storage.
	•	SQS for reliable message-based communication.
	5.	Thread-Safe Processing:
	•	Manages concurrent operations with thread-safe data structures.
	6.	Database Support:
	•	SQLite for development, PostgreSQL for production.
	•	Automated schema management via SQL scripts.

Architecture
	•	Dynamic Querying:
	•	Implements flexible and modular search operations.
	•	Distributed Processing:
	•	Leverages AWS services for scalability.
	•	Multi-threaded Operations:
	•	Ensures high performance and thread safety.

Tech Stack
	•	Backend: Java, SLF4J, SQL.
	•	Database: SQLite, PostgreSQL.
	•	Tools: AWS S3, AWS SQS.
 
