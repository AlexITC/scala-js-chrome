package chrome.downloads.bindings

sealed trait InterruptReason

object InterruptReason {
  val FILE_FAILED: InterruptReason = "FILE_FAILED".asInstanceOf[InterruptReason]
  val FILE_ACCESS_DENIED: InterruptReason = "FILE_ACCESS_DENIED".asInstanceOf[InterruptReason]
  val FILE_NO_SPACE: InterruptReason = "FILE_NO_SPACE".asInstanceOf[InterruptReason]
  val FILE_NAME_TOO_LONG: InterruptReason = "FILE_NAME_TOO_LONG".asInstanceOf[InterruptReason]
  val FILE_TOO_LARGE: InterruptReason = "FILE_TOO_LARGE".asInstanceOf[InterruptReason]
  val FILE_VIRUS_INFECTED: InterruptReason = "FILE_VIRUS_INFECTED".asInstanceOf[InterruptReason]
  val FILE_TRANSIENT_ERROR: InterruptReason = "FILE_TRANSIENT_ERROR".asInstanceOf[InterruptReason]
  val FILE_BLOCKED: InterruptReason = "FILE_BLOCKED".asInstanceOf[InterruptReason]
  val FILE_SECURITY_CHECK_FAILED: InterruptReason = "FILE_SECURITY_CHECK_FAILED".asInstanceOf[InterruptReason]
  val FILE_TOO_SHORT: InterruptReason = "FILE_TOO_SHORT".asInstanceOf[InterruptReason]
  val FILE_HASH_MISMATCH: InterruptReason = "FILE_HASH_MISMATCH".asInstanceOf[InterruptReason]
  val NETWORK_FAILED: InterruptReason = "NETWORK_FAILED".asInstanceOf[InterruptReason]
  val NETWORK_TIMEOUT: InterruptReason = "NETWORK_TIMEOUT".asInstanceOf[InterruptReason]
  val NETWORK_DISCONNECTED: InterruptReason = "NETWORK_DISCONNECTED".asInstanceOf[InterruptReason]
  val NETWORK_SERVER_DOWN: InterruptReason = "NETWORK_SERVER_DOWN".asInstanceOf[InterruptReason]
  val NETWORK_INVALID_REQUEST: InterruptReason = "NETWORK_INVALID_REQUEST".asInstanceOf[InterruptReason]
  val SERVER_FAILED: InterruptReason = "SERVER_FAILED".asInstanceOf[InterruptReason]
  val SERVER_NO_RANGE: InterruptReason = "SERVER_NO_RANGE".asInstanceOf[InterruptReason]
  val SERVER_BAD_CONTENT: InterruptReason = "SERVER_BAD_CONTENT".asInstanceOf[InterruptReason]
  val SERVER_UNAUTHORIZED: InterruptReason = "SERVER_UNAUTHORIZED".asInstanceOf[InterruptReason]
  val SERVER_CERT_PROBLEM: InterruptReason = "SERVER_CERT_PROBLEM".asInstanceOf[InterruptReason]
  val SERVER_FORBIDDEN: InterruptReason = "SERVER_FORBIDDEN".asInstanceOf[InterruptReason]
  val SERVER_UNREACHABLE: InterruptReason = "SERVER_UNREACHABLE".asInstanceOf[InterruptReason]
  val USER_CANCELED: InterruptReason = "USER_CANCELED".asInstanceOf[InterruptReason]
  val USER_SHUTDOWN: InterruptReason = "USER_SHUTDOWN".asInstanceOf[InterruptReason]
  val CRASH: InterruptReason = "CRASH".asInstanceOf[InterruptReason]
}
