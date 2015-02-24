
# Sqwiggle4J

Sqwiggle API with RxJava 

## Setup

```
$ git clone https://github.com/asufana/Sqwiggle4J
$ cd Sqwiggle4J
$ mvn install
```

## Examples

### User

```java
final String TOKEN = "your sqwiggle token";

final Integer userId = 43880;
final rx.Observable<User> user = new Sqwiggle4J(TOKEN).user(userId);
user.forEach(u -> {
    System.out.println(u);
});

    //User(id=43880, role=user, status=available, confirmed=true, message=, email=makoto.hanafusa@g.soliton.co.jp, name=HANA, avatar=https://sqwiggle-photos.s3.amazonaws.com/43880/avatar/db9cf14a0b7f63a8260ab9e5e69bc934229a9a21_120_120.jpg?1417052959310, timeZone=Osaka, isContact=null, contact=null, timeZoneOffset=9.0, snapshot=https://sqwiggle-photos.s3.amazonaws.com/43880/avatar/db9cf14a0b7f63a8260ab9e5e69bc934229a9a21_ba28cf3df5d702fc1518960f26918bdc15e5b5a5.jpg?1424781994488, snapshotInterval=60, lastActiveAt=2015-02-24T21:46:34.577+09:00, lastConnectedAt=2015-02-24T09:11:42.530+09:00, createdAt=2014-11-19T10:34:21.792+09:00, mediaDeviceId=null, idleAt=2015-02-24T10:01:48.000Z, support=false)
```

### Users

```java
final rx.Observable<User> users = new Sqwiggle4J(TOKEN).users();
users.forEach(u -> {
    System.out.println(u);
});

    //User(id=43880, role=user, status=available, confirmed=true, message=, email=makoto.hanafusa@g.soliton.co.jp, name=HANA, avatar=https://sqwiggle-photos.s3.amazonaws.com/43880/avatar/db9cf14a0b7f63a8260ab9e5e69bc934229a9a21_120_120.jpg?1417052959310, timeZone=Osaka, isContact=null, contact=null, timeZoneOffset=9.0, snapshot=https://sqwiggle-photos.s3.amazonaws.com/43880/avatar/db9cf14a0b7f63a8260ab9e5e69bc934229a9a21_ba28cf3df5d702fc1518960f26918bdc15e5b5a5.jpg?1424781994488, snapshotInterval=60, lastActiveAt=2015-02-24T21:46:34.577+09:00, lastConnectedAt=2015-02-24T09:11:42.530+09:00, createdAt=2014-11-19T10:34:21.792+09:00, mediaDeviceId=null, idleAt=2015-02-24T10:01:48.000Z, support=false)
    //User(id=...
```

### Message

```java
final Integer messageId = 3532196;
final rx.Observable<Message> message = new Sqwiggle4J(TOKEN).message(messageId);
message.forEach(m -> {
    System.out.println(m);
});

	//Message(id=3532196, createdAt=2015-02-20T06:25:31.556Z, updatedAt=2015-02-20T06:25:31.556Z, conversationId=null, streamId=25077, mentions=[], author=Message.Author(id=442, name=Hubot, avatar=https://sqwiggle-assets.s3.amazonaws.com/assets/api/octocat.png, type=client, support=false), type=message, text=http://boukenka.info/wp-content/uploads/2013/11/%E3%82%B9%E3%83%8D%E5%A4%AB%EF%BC%92.jpg, attachments=[Message.Attachment(id=210654, title=null, animated=false, type=image, image=http://boukenka.info/wp-content/uploads/2013/11/%E3%82%B9%E3%83%8D%E5%A4%AB%EF%BC%92.jpg, status=null, width=null, height=null, createdAt=2015-02-20T06:25:32.700Z, updatedAt=2015-02-20T06:25:32.700Z)])
```

### Messages

```java
final rx.Observable<Message> messages = new Sqwiggle4J(TOKEN).messages();
messages.forEach(m -> {
    System.out.println(m);
});

	//Message(id=3532196, createdAt=2015-02-20T06:25:31.556Z, updatedAt=2015-02-20T06:25:31.556Z, conversationId=null, streamId=25077, mentions=[], author=Message.Author(id=442, name=Hubot, avatar=https://sqwiggle-assets.s3.amazonaws.com/assets/api/octocat.png, type=client, support=false), type=message, text=http://boukenka.info/wp-content/uploads/2013/11/%E3%82%B9%E3%83%8D%E5%A4%AB%EF%BC%92.jpg, attachments=[Message.Attachment(id=210654, title=null, animated=false, type=image, image=http://boukenka.info/wp-content/uploads/2013/11/%E3%82%B9%E3%83%8D%E5%A4%AB%EF%BC%92.jpg, status=null, width=null, height=null, createdAt=2015-02-20T06:25:32.700Z, updatedAt=2015-02-20T06:25:32.700Z)])
	//Message(id=...
```

