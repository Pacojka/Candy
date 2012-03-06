package com.bgame

class Message {
 Date dateCreated
 String titel
 String text
 User user
 User sender
    static constraints = {
        sender(nullable:true)
    }


static void deletemessage(id,user) {
	def u = Message.findByIdAndUser(id,user)
	if (u)
	{
		u.sender?.removeFromMessages(u)
		user?.removeFromMessages(u)
		u.delete()
	}
}

static Usritm addmessage(item, user) {
	def u = new Usritm()
	item?.addToUseritems(u)
	user?.addToUseritems(u)
	u.save()
	return u
}
}