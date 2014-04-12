/**
 *  ChildDevice
 *
 *  Author: Steve Vlaminck
 *  Date: 2014-04-12
 */
// for the UI
metadata {
	definition(name: "ChildDevice", namespace: "Minnebar9", author: "Steve Vlaminck") {
	}

	simulator {
		// TODO: define status and reply messages here
	}

	tiles {
		valueTile("bar", "device.bar", decoration: "flat") {
			state "bar", label: '${currentValue}'
		}

		main(["bar"])
		details(["bar"])

	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"

}

// ========================================================
// Read
// ========================================================

def getBar() {
	return state.bar ?: "MinneBar9 FTW"
}

// ========================================================
// Update
// ========================================================

def setBar(newBar) {
	state.bar = newBar
	sendEvent(name: "bar", value: newBar)
}

// ========================================================
// Interact With Parent
// ========================================================

def getStoryFromParent() {
	def parent = app.getParent()

	return parent.getStory()
}

def setStoryOnParent(newStory) {
	def parent = app.getParent()

	return parent.setStory(newStory)
}