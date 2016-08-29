LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := lb_beautify
LOCAL_SRC_FILES := lb_beautify.cpp

include $(BUILD_SHARED_LIBRARY)
